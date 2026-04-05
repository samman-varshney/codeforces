package HLD;

import java.util.*;
import java.io.*;

public class QTREE {

    // -------------------------Boiler Code----------------------//
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // -------------------------DSU--------------------------------
    static int[] parent, size;
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static String nextStr() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public static void println(int x) throws IOException {
        bw.write(Integer.toString(x));
        bw.newLine();
    }

    static int n;
    static List<List<Triplet>> adj;

    public static void main(String[] args) {
        try {
            int tcase = nextInt();
            while (tcase-- > 0) {
                n = nextInt();
                adj = new ArrayList<>();
                for (int i = 0; i <= n; i++)
                    adj.add(new ArrayList<>());

                for (int i = 0; i < n - 1; i++) {
                    int u = nextInt();
                    int v = nextInt();
                    int cost = nextInt();

                    adj.get(u).add(new Triplet(v, cost, i + 1));
                    adj.get(v).add(new Triplet(u, cost, i + 1));
                }

                helper();
            }
        } catch (Exception err) {
            System.err.println("An unexpected error occurred:");
            err.printStackTrace();
        }
    }

    static int[] heavy, depth, map, values;

    static void dfs(int u) {
        for (Triplet v : adj.get(u)) {
            if (v.node != parent[u]) {
                parent[v.node] = u;
                depth[v.node] = depth[u] + 1;
                map[v.pos] = v.node;
                values[v.node] = v.cost;

                dfs(v.node);

                size[u] += size[v.node];
                if (size[heavy[u]] < size[v.node])
                    heavy[u] = v.node;
            }
        }
        size[u]++;
    }

    static int[] head, lt, pos;
    static int idx;

    static void dfsHLD(int u, int chain) {
        head[u] = chain;
        lt[idx] = values[u];
        pos[u] = idx;
        idx++;

        if (heavy[u] != 0) {
            dfsHLD(heavy[u], chain);
        }

        for (Triplet v : adj.get(u)) {
            if (v.node != heavy[u] && v.node != parent[u]) {
                dfsHLD(v.node, v.node);
            }
        }
    }

    static int[] t;

    static void build(int v, int l, int r) {
        if (l == r) {
            t[v] = lt[l];
        } else {
            int mid = (l + r) / 2;
            build(2 * v, l, mid);
            build(2 * v + 1, mid + 1, r);

            t[v] = Math.max(t[2 * v], t[2 * v + 1]);
        }
    }

    static void update(int v, int l, int r, int idx, int val) {
        if (l == idx && r == idx) {
            t[v] = val;
        } else {
            int mid = (l + r) / 2;
            if (idx <= mid) {
                update(2 * v, l, mid, idx, val);
            } else {
                update(2 * v + 1, mid + 1, r, idx, val);
            }

            t[v] = Math.max(t[2 * v], t[2 * v + 1]);
        }
    }

    static int query(int v, int tl, int tr, int l, int r) {
        if (tl >= l && tr <= r) {
            return t[v];
        } else if (tr < l || tl > r) {
            return Integer.MIN_VALUE;
        } else {
            int mid = (tl + tr) / 2;
            return Math.max(query(2 * v, tl, mid, l, r),
                    query(2 * v + 1, mid + 1, tr, l, r));
        }
    }

    static int getMaxEdgeCost(int a, int b) {
        int res = Integer.MIN_VALUE;
        while (head[a] != head[b]) {
            if (depth[head[a]] < depth[head[b]]) {
                int t = a;
                a = b;
                b = t;
            }
            res = Math.max(res, query(1, 0, n - 1, pos[head[a]], pos[a]));
            a = parent[head[a]];
        }

        if (a == b)
            return res == Integer.MIN_VALUE ? 0 : res;

        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        res = Math.max(res, query(1, 0, n - 1, pos[b] + 1, pos[a]));
        return res;
    }

    public static void helper() throws IOException {
        heavy = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        depth = new int[n + 1];
        map = new int[n + 1];
        values = new int[n + 1];

        dfs(1);

        head = new int[n + 1];
        lt = new int[n + 1];
        pos = new int[n + 1];
        idx = 0;

        dfsHLD(1, 1);

        t = new int[4 * (n + 1)];
        build(1, 0, n);

        while (true) {
            String type = nextStr();
            if (type.equals("DONE"))
                break;
            else if (type.equals("CHANGE")) {
                int edge = nextInt();
                int u = map[edge];
                int cost = nextInt();
                update(1, 0, n, pos[u], cost);
            } else {
                int u = nextInt();
                int v = nextInt();
                println(getMaxEdgeCost(u, v));
            }
        }
        bw.flush();
    }
}

class Triplet {
    int node, cost, pos;

    Triplet(int node, int cost, int pos) {
        this.node = node;
        this.cost = cost;
        this.pos = pos;
    }
}