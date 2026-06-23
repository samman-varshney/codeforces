import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class YashBansal {

    static class Node {
        String name;
        volatile int lockedBy; // protected by node write lock
        AtomicInteger lockedDescendants; // safe for concurrent updates
        Node parent;
        List<Node> children;
        ReentrantReadWriteLock rwLock; // per-node lock

        public Node(String name) {
            this.name = name;
            this.lockedBy = 0;
            this.lockedDescendants = new AtomicInteger(0);
            this.children = new ArrayList<>();
            this.rwLock = new ReentrantReadWriteLock(true);
        }
    }

    static class LockingTree {
        Map<String, Node> map;
        Node root;

        public LockingTree(String[] nodes, int m) {
            int n = nodes.length;
            map = new HashMap<>();
            List<Node> nodeList = new ArrayList<>(n);

            for (String name : nodes) {
                Node node = new Node(name);
                nodeList.add(node);
                map.put(name, node);
            }

            for (int i = 0; i < n; i++) {
                Node curr = nodeList.get(i);
                int firstChildIndex = m * i + 1;

                for (int j = 0; j < m; j++) {
                    int childIndex = firstChildIndex + j;
                    if (childIndex < n) {
                        Node child = nodeList.get(childIndex);
                        child.parent = curr;
                        curr.children.add(child);
                    } else {
                        break;
                    }
                }
            }

            root = nodeList.get(0);
        }

        public boolean lock(String name, int uid) {
            Node node = map.get(name);
            if (node == null)
                return false;

            List<Node> ancestors = getAncestors(node.parent);
            lockRead(ancestors);
            node.rwLock.writeLock().lock();

            try {
                if (node.lockedBy != 0)
                    return false;
                if (node.lockedDescendants.get() > 0)
                    return false;
                if (hasLockedAncestor(ancestors))
                    return false;

                node.lockedBy = uid;
                updateAncestorsCount(ancestors, 1);
                return true;
            } finally {
                node.rwLock.writeLock().unlock();
                unlockReadReverse(ancestors);
            }
        }

        public boolean unlock(String name, int uid) {
            Node node = map.get(name);
            if (node == null)
                return false;

            List<Node> ancestors = getAncestors(node.parent);
            lockRead(ancestors);
            node.rwLock.writeLock().lock();

            try {
                if (node.lockedBy != uid)
                    return false;

                node.lockedBy = 0;
                updateAncestorsCount(ancestors, -1);
                return true;
            } finally {
                node.rwLock.writeLock().unlock();
                unlockReadReverse(ancestors);
            }
        }

        public boolean upgrade(String name, int uid) {
            Node node = map.get(name);
            if (node == null)
                return false;

            List<Node> ancestors = getAncestors(node.parent);
            lockRead(ancestors);
            node.rwLock.writeLock().lock();

            try {
                if (node.lockedBy != 0)
                    return false;
                if (node.lockedDescendants.get() == 0)
                    return false;
                if (hasLockedAncestor(ancestors))
                    return false;

                List<Node> lockedNodes = new ArrayList<>();
                collectLockedDescendants(node, lockedNodes);

                if (lockedNodes.isEmpty())
                    return false;

                for (Node x : lockedNodes) {
                    if (x.lockedBy != uid)
                        return false;
                }

                // unlock all locked descendants
                for (Node x : lockedNodes) {

                    x.lockedBy = 0;
                    updateAncestorsCount(getAncestors(x.parent), -1);
                }

                // lock current node
                node.lockedBy = uid;
                updateAncestorsCount(ancestors, 1);
                return true;
            } finally {
                node.rwLock.writeLock().unlock();
                unlockReadReverse(ancestors);
            }
        }

        private List<Node> getAncestors(Node node) {
            List<Node> path = new ArrayList<>();
            while (node != null) {
                path.add(node);
                node = node.parent;
            }
            Collections.reverse(path);
            return path;
        }

        private void lockRead(List<Node> nodes) {
            for (Node node : nodes) {
                node.rwLock.readLock().lock();
            }
        }

        private void unlockReadReverse(List<Node> nodes) {
            for (int i = nodes.size() - 1; i >= 0; i--) {
                nodes.get(i).rwLock.readLock().unlock();
            }
        }

        private boolean hasLockedAncestor(List<Node> ancestors) {
            for (Node anc : ancestors) {
                if (anc.lockedBy != 0)
                    return true;
            }
            return false;
        }

        private void updateAncestorsCount(List<Node> ancestors, int delta) {
            for (Node anc : ancestors) {
                anc.lockedDescendants.addAndGet(delta);
            }
        }

        private void collectLockedDescendants(Node node, List<Node> lockedNodes) {
            for (Node child : node.children) {
                if (child.lockedBy != 0) {
                    lockedNodes.add(child);
                }
                if (child.lockedDescendants.get() > 0) {
                    collectLockedDescendants(child, lockedNodes);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        String[] nodes = new String[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.next();
        }

        LockingTree tree = new LockingTree(nodes, m);
        StringBuilder result = new StringBuilder();

        while (q-- > 0) {
            String operation = sc.next();
            String node = sc.next();
            int userId = sc.nextInt();

            boolean res = false;
            if (operation.equals("1")) {
                res = tree.lock(node, userId);
            } else if (operation.equals("2")) {
                res = tree.unlock(node, userId);
            } else if (operation.equals("3")) {
                res = tree.upgrade(node, userId);
            }

            result.append(res).append(" ");
        }

        System.out.println(result.toString().trim());
        sc.close();
    }
}