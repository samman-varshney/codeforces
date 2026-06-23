import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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

        while (!node.inProcess.compareAndSet(0, 1))
            Thread.yield();

        try {

            if (node.lockedById != -1 || node.lockedDecesndents.size() != 0) {

                return false;
            }

            Node parent = node.parent;
            Stack<Node> st = new Stack<>();
            while (parent != null) {
                // claim and test
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

            return true;
        } finally {
            node.inProcess.set(0);
        }

    }

    public static boolean unlock(String country, int uid) {
        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        if (!node.inProcess.compareAndSet(0, 1))
            return false;

        try {
            if (node.lockedById != uid) {
                node.inProcess.set(0);
                return false;
            }

            Node parent = node.parent;

            node.lockedById = -1;
            while (parent != null) {
                // no need of claim and test
                parent.lockedDecesndents.remove(node);
                parent = parent.parent;
            }

            return true;
        } finally {
            node.inProcess.set(0);
        }

    }

    public static boolean upgrade(String country, int uid) {
        Node node = mapNodes.get(country);
        if (node == null)
            return false;

        if (!node.inProcess.compareAndSet(0, 1)) {

            return false;
        }

        try {

            if (node.lockedById != -1 || node.lockedDecesndents.size() == 0) {
                node.inProcess.set(0);
                return false;
            }

            for (Node locked : node.lockedDecesndents) {
                if (locked.lockedById != uid) {
                    node.inProcess.set(0);
                    return false;
                }
            }

            // first registering the node to ancestors
            Node parent = node.parent;
            Stack<Node> st = new Stack<>();
            while (parent != null) {
                parent.lockedDecesndents.add(node);
                st.push(parent);
                if (parent.lockedById != -1 || parent.inProcess.get() == 1) {
                    while (!st.isEmpty()) {
                        st.pop().lockedDecesndents.remove(node);
                    }
                    return false;
                }

                parent = parent.parent;
            }

            List<Node> snapshot = new ArrayList<>(node.lockedDecesndents);
            for (Node locked : snapshot) {
                unlock(locked.name, uid);
            }

            node.lockedById = uid;
            return true;

        } finally {
            node.inProcess.set(0);
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
                Node parent = q.peek();
                parent.children++;
                curr.parent = parent;
                if (parent.children >= m)
                    q.poll();
            }

            q.add(curr);
        }

    }
}
