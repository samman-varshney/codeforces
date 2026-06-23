import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class yashCAS {

    static class Node {
        String name;
        int lockedBy; // protected by CAS path lock
        Set<Node> lockedDescendants; // safe because path is locked
        Node parent;
        List<Node> children;
        AtomicBoolean busy; // CAS spin lock for this node

        Node(String name) {
            this.name = name;
            this.lockedBy = 0;
            this.lockedDescendants = new HashSet<>();
            this.children = new ArrayList<>();
            this.busy = new AtomicBoolean(false);
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

            List<Node> path = getPath(node);
            acquirePath(path);
            try {
                if (node.lockedBy != 0)
                    return false;
                if (!node.lockedDescendants.isEmpty())
                    return false;
                if (hasLockedAncestor(path))
                    return false;

                node.lockedBy = uid;
                updateAncestorsLockedDescendants(path, node, true);
                return true;
            } finally {
                releasePath(path);
            }
        }

        public boolean unlock(String name, int uid) {
            Node node = map.get(name);
            if (node == null)
                return false;

            List<Node> path = getPath(node);
            acquirePath(path);
            try {
                if (node.lockedBy != uid)
                    return false;

                node.lockedBy = 0;
                updateAncestorsLockedDescendants(path, node, false);
                return true;
            } finally {
                releasePath(path);
            }
        }

        public boolean upgrade(String name, int uid) {
            Node node = map.get(name);
            if (node == null)
                return false;

            List<Node> path = getPath(node);
            acquirePath(path);
            try {
                if (node.lockedBy != 0)
                    return false;
                if (hasLockedAncestor(path))
                    return false;
                if (node.lockedDescendants.isEmpty())
                    return false;

                List<Node> lockedNodes = new ArrayList<>(node.lockedDescendants);
                for (Node x : lockedNodes) {
                    if (x.lockedBy != uid)
                        return false;
                }

                // unlock all locked descendants
                for (Node x : lockedNodes) {
                    x.lockedBy = 0;
                    List<Node> xPath = getPath(x);
                    updateAncestorsLockedDescendants(xPath, x, false);
                }

                // lock current node
                node.lockedBy = uid;
                updateAncestorsLockedDescendants(path, node, true);
                return true;
            } finally {
                releasePath(path);
            }
        }

        private List<Node> getPath(Node node) {
            List<Node> path = new ArrayList<>();
            while (node != null) {
                path.add(node);
                node = node.parent;
            }
            Collections.reverse(path); // root -> target
            return path;
        }

        private void acquirePath(List<Node> path) {
            while (true) {
                int acquired = 0;
                boolean ok = true;

                for (Node node : path) {
                    if (node.busy.compareAndSet(false, true)) {
                        acquired++;
                    } else {
                        ok = false;
                        break;
                    }
                }

                if (ok)
                    return;

                for (int i = acquired - 1; i >= 0; i--) {
                    path.get(i).busy.set(false);
                }

                Thread.yield();
            }
        }

        private void releasePath(List<Node> path) {
            for (int i = path.size() - 1; i >= 0; i--) {
                path.get(i).busy.set(false);
            }
        }

        private boolean hasLockedAncestor(List<Node> path) {
            for (int i = 0; i < path.size() - 1; i++) {
                if (path.get(i).lockedBy != 0)
                    return true;
            }
            return false;
        }

        private void updateAncestorsLockedDescendants(List<Node> path, Node target, boolean add) {
            for (int i = 0; i < path.size() - 1; i++) {
                Node anc = path.get(i);
                if (add) {
                    anc.lockedDescendants.add(target);
                } else {
                    anc.lockedDescendants.remove(target);
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