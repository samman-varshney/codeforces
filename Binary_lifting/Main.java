package Binary_lifting;

import java.util.*;
import java.io.*;

class Pair {
    int v, x;

    Pair(int v, int x) {
        this.v = v;
        this.x = x;
    }
}

public class Main {
    static int[] parent;
    static int[][] dp;
    static int limit = 18; // Enough for 2*10^5
    static int[] depth;
    static long[] prefix, suffix;
    static List<List<Pair>> adj;
    static int n;

    static void dfs(int v, int p, int d, long pref) {
        parent[v] = p;
        depth[v] = d;
        prefix[v] = pref;
        long maxChildPath = 0;

        for (Pair edge : adj.get(v)) {
            if (edge.v != p) {
                dfs(edge.v, v, d + 1, pref + edge.x);
                maxChildPath = Math.max(maxChildPath, suffix[edge.v] + edge.x);
            }
        }
        suffix[v] = maxChildPath;
    }

    static void build() {
        dp = new int[n][limit + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }

        for (int j = 1; j <= limit; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] = dp[dp[i][j - 1]][j - 1];
            }
        }
    }

    static int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];
        for (int i = 0; i <= limit; i++) {
            if (((diff >> i) & 1) == 1) {
                a = dp[a][i];
            }
        }

        if (a == b)
            return a;

        for (int i = limit; i >= 0; i--) {
            if (dp[a][i] != dp[b][i]) {
                a = dp[a][i];
                b = dp[b][i];
            }
        }
        return dp[a][0];
    }

    public static void main(String[] args) {
        // Increase stack size for deep trees
        Thread t = new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {
            }
        }, "solve", 1 << 28);
        t.start();
    }

    static void solve() throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            int q = sc.nextInt();

            adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                int w = sc.nextInt();
                adj.get(u).add(new Pair(v, w));
                adj.get(v).add(new Pair(u, w));
            }

            prefix = new long[n];
            suffix = new long[n];
            depth = new int[n];
            parent = new int[n];

            dfs(0, 0, 0, 0); // Root parent is itself for binary lifting safety
            build();

            for (int i = 0; i < q; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                int x = sc.nextInt();

                // Option 1: Path using the new bridge edge
                long bridgePath = suffix[u] + suffix[v] + x;

                // Option 2: Original tree path
                int lca = getLCA(u, v);
                long treePath = prefix[u] + prefix[v] - 2 * prefix[lca];

                out.print(Math.max(bridgePath, treePath) + (i == q - 1 ? "" : " "));
            }
            out.println();
        }
        out.flush();
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}