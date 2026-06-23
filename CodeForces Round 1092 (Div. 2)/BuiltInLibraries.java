import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Node {
    String name;
    int children;
    Set<Node> lockedDecesdent;
    Node parent;
    volatile int lockedById;
    ReadWriteLock rwLock;

    public Node(String name) {
        this.name = name;
        this.lockedDecesdent = ConcurrentHashMap.newKeySet();
        this.lockedById = -1;
        this.parent = null;
        this.children = 0;
        this.rwLock = new ReentrantReadWriteLock();
    }

    public void acquireReadLock() {
        this.rwLock.readLock().lock();
    }

    public void releaseReadLock() {
        this.rwLock.readLock().unlock();
    }

    public void acquireWriteLock() {
        this.rwLock.writeLock().lock();
    }

    public void releaseWriteLock() {
        this.rwLock.writeLock().unlock();
    }
}

public class BuiltInLibraries {
    private static ConcurrentHashMap<String, Node> mapNodes;

    // Target node's own state -> WRITE lock, held for the whole call.
    // Each ancestor, while we register ourselves with it -> READ lock only:
    // we just need to exclude a concurrent WRITE-lock holder on that same
    // ancestor (i.e. someone directly locking/unlocking/upgrading it).
    // Two threads registering different descendants under the same free
    // ancestor don't conflict with each other and shouldn't serialize.
    private static boolean lock(String country, int uid) {
        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        node.acquireWriteLock();
        try {
            if (node.lockedById != -1 || !node.lockedDecesdent.isEmpty())
                return false;

            List<Node> claimed = new ArrayList<>();
            Node parent = node.parent;
            while (parent != null) {
                parent.acquireReadLock();
                try {
                    if (parent.lockedById != -1) {
                        for (Node t : claimed)
                            t.lockedDecesdent.remove(node);
                        return false;
                    }
                    parent.lockedDecesdent.add(node);
                    claimed.add(parent);
                } finally {
                    parent.releaseReadLock();
                }
                parent = parent.parent;
            }

            node.lockedById = uid;
            return true;
        } finally {
            node.releaseWriteLock();
        }
    }

    // No lock needed on the ancestors at all. remove() on a thread-safe
    // concurrent set is independently safe, and removing a registration
    // only ever makes the tree MORE permissive -- it can never cause a
    // node and an ancestor to incorrectly appear locked simultaneously.
    // This is also what breaks the upgrade-vs-unlock deadlock: unlock()
    // never reaches upward for a lock at all.
    private static boolean unlock(String country, int uid) {
        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        node.acquireWriteLock();
        try {
            if (node.lockedById != uid)
                return false;
            node.lockedById = -1;

            Node parent = node.parent;
            while (parent != null) {
                parent.lockedDecesdent.remove(node);
                parent = parent.parent;
            }
            return true;
        } finally {
            node.releaseWriteLock();
        }
    }

    // Ownership-verification loop is a single volatile read per descendant
    // -- no lock needed, lockedById is already atomic and visible on its
    // own and nothing is modified here. This is the other half of what
    // breaks the deadlock: upgrade() never reaches downward for a lock.
    // Ancestor registration uses the same read-lock discipline as lock(),
    // and happens BEFORE releasing the descendants, so no ancestor's
    // bottom set is ever empty mid-upgrade.
    private static boolean upgrade(String country, int uid) {
        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        node.acquireWriteLock();
        try {
            if (node.lockedById != -1 || node.lockedDecesdent.isEmpty())
                return false;

            for (Node locked : node.lockedDecesdent) {
                if (locked.lockedById != uid)
                    return false;
            }

            List<Node> claimed = new ArrayList<>();
            Node parent = node.parent;
            while (parent != null) {
                parent.acquireReadLock();
                try {
                    if (parent.lockedById != -1) {
                        for (Node t : claimed)
                            t.lockedDecesdent.remove(node);
                        return false;
                    }
                    parent.lockedDecesdent.add(node);
                    claimed.add(parent);
                } finally {
                    parent.releaseReadLock();
                }
                parent = parent.parent;
            }

            List<Node> snapshot = new ArrayList<>(node.lockedDecesdent);
            for (Node locked : snapshot) {
                unlock(locked.name, uid);
            }

            node.lockedById = uid;
            return true;
        } finally {
            node.releaseWriteLock();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        String[] countries = sc.nextLine().split(" ");
        mapNodes = new ConcurrentHashMap<>();
        buildTree(countries, m);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            String country = sc.next();
            int uid = sc.nextInt();

            switch (type) {
                case 1:
                    result.append(lock(country, uid) + "\n");
                    break;
                case 2:
                    result.append(unlock(country, uid) + "\n");
                    break;
                default: // assuming there is no 4th type
                    result.append(upgrade(country, uid) + "\n");
                    break;
            }
        }
        System.out.print(result);
        sc.close();
    }

    private static void buildTree(String[] countries, int m) {
        Queue<Node> q = new ArrayDeque<>();
        for (String country : countries) {
            Node curr = new Node(country);
            mapNodes.put(country, curr);

            if (!q.isEmpty()) {
                Node parent = q.peek();
                curr.parent = parent;
                if (++parent.children == m) {
                    q.poll();
                }
            }
            q.add(curr);
        }
    }
}