package Rating1400;

import java.util.*;

public class TreeOfSpace {

    private static HashMap<String, Node> mapNodes;

    private static boolean lock(String name, int uId) {
        Node node = mapNodes.get(name);

        if (node == null || node.lockedById != -1 ||
                node.lockedDescendants.isEmpty() || hasLockedAncestor(node))
            return false;

        node.lock(uId);
        return true;
    }

    private static boolean unlock(String name, int uId) {
        Node node = mapNodes.get(name);

        if (node == null || node.lockedById != uId)
            return false;

        node.unlock();
        return true;
    }

    private static boolean upgrade(String name, int uId) {
        Node node = mapNodes.get(name);

        if (node == null || node.lockedById != -1 ||
                node.lockedDescendants.isEmpty() || hasLockedAncestor(node))
            return false;

        for (Node descendent : node.lockedDescendants) {
            if (descendent.lockedById != uId)
                return false;
        }

        for (Node descendent : node.lockedDescendants) {
            descendent.unlock();
        }

        node.lock(uId);
        return true;
    }

    private static boolean hasLockedAncestor(Node node) {
        Node parent = node.parent;
        while (parent != null) {
            if (parent.lockedById != -1)
                return true;
            parent = parent.parent;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        String[] countries = sc.next().split(" ");
        mapNodes = new HashMap<>();
        buildWorldMap(countries, m);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            String name = sc.next();
            int uId = sc.nextInt();

            switch (type) {
                case 1:
                    res.append(lock(name, uId) + " ");
                    break;
                case 2:
                    res.append(unlock(name, uId) + " ");
                    break;
                case 3:
                    res.append(upgrade(name, uId) + " ");
                    break;
                default:
                    throw new Error("Invalid Operation");
            }
        }
        System.out.println(res.toString());
        sc.close();
    }

    private static void buildWorldMap(String[] countries, int m) {
        Queue<Node> q = new ArrayDeque<>();
        for (String country : countries) {
            Node curr = new Node(country);
            mapNodes.put(country, curr);

            if (!q.isEmpty()) {
                Node parent = q.peek();
                parent.children.add(curr);
                curr.parent = parent;

                if (parent.children.size() == m)
                    q.poll();
            }

        }

    }
}

class Node {
    enum Status {
        ADD,
        REMOVE
    }

    String name;
    int lockedById;
    List<Node> children;
    Node parent;
    Set<Node> lockedDescendants;

    public Node(String name) {
        this.name = name;
        this.lockedById = -1;
        this.children = new ArrayList<>();
        this.parent = null;
        this.lockedDescendants = new HashSet<>();
    }

    public void lock(int uId) {
        this.lockedById = uId;
        updateAncestors(Status.ADD);
    }

    public void unlock() {
        this.lockedById = -1;
        updateAncestors(Status.REMOVE);
    }

    public void updateAncestors(Status status) {
        Node parent = this.parent;
        while (parent != null) {
            switch (status) {
                case ADD:
                    parent.lockedDescendants.add(this);
                    break;

                case REMOVE:
                    parent.lockedDescendants.remove(this);
            }
            parent = parent.parent;
        }
    }
}