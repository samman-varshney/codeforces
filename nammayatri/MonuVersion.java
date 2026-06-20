package nammayatri;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Node {
    String name;
    volatile int lockedById;
    Set<Node> lockedDecesndents;
    int children;
    Node parent;
    AtomicInteger inProcess;

    public Node(String name) {
        this.name = name;
        this.lockedById = -1;
        this.lockedDecesndents = ConcurrentHashMap.newKeySet();
        this.parent = null;
        this.inProcess = new AtomicInteger(0);
        this.children = 0;
    }

}

public class MonuVersion {
    static ConcurrentHashMap<String, Node> mapNodes;

    public static boolean lock(String country, int uid) {

        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        if (!node.inProcess.compareAndSet(0, 1))
            return false;

        if (node.lockedById != -1 || node.lockedDecesndents.size() != 0) {
            node.inProcess.set(0);
            return false;
        }

        Node parent = node.parent;
        Stack<Node> st = new Stack<>();
        while (parent != null) {
            parent.lockedDecesndents.add(node);
            st.add(parent);

            if (parent.lockedById != -1 || parent.inProcess.get() == 1) {
                // rollback
                while (!st.isEmpty()) {
                    st.pop().lockedDecesndents.remove(node);
                }
                // doesn't require compare and swap
                node.inProcess.set(0);
                return false;
            }

            parent = parent.parent;
        }

        node.lockedById = uid;
        node.inProcess.set(0);

        return true;

    }

    public static boolean unlock(String country, int uid) {
        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        if (!node.inProcess.compareAndSet(0, 1))
            return false;
        if (node.lockedById != uid) {
            node.inProcess.set(0);
            return false;
        }

        Node parent = node.parent;

        while (parent != null) {
            parent.lockedDecesndents.remove(node);
            parent = parent.parent;
        }

        node.lockedById = -1;

        node.inProcess.set(0);
        return true;

    }

    public static boolean upgrade(String country, int uid) {
        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        if (!node.inProcess.compareAndSet(0, 1)) {

            return false;
        }

        if (node.lockedById == -1 || node.lockedDecesndents.size() == 0) {
            node.inProcess.set(0);
            return false;
        }

        for (Node locked : node.lockedDecesndents) {
            if (locked.lockedById != uid) {
                node.inProcess.set(0);
                return false;
            }
        }

        for (Node locked : node.lockedDecesndents) {
            unlock(locked.name, uid);
        }

        node.lockedById = uid;
        node.inProcess.set(0);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

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
                case 3:
                    result.append(upgrade(country, uid) + "\n");
                    break;

                default:
                    break;
            }
        }

        System.out.print(result.toString());
        sc.close();

    }

    public static void buildTree(String[] countries, int m) {
        Queue<Node> q = new ArrayDeque<>();

        for (String country : countries) {
            Node curr = new Node(country);
            mapNodes.put(country, curr);

            if (!q.isEmpty()) {
                Node parent = q.poll();
                parent.children++;
                curr.parent = parent;
                if (parent.children >= m)
                    q.poll();
            }

            q.add(curr);
        }

    }
}
