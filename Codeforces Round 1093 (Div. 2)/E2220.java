import java.io.*;
import java.util.*;

public class E2220 {
    static final double INF = 1e15;

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int t = in.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }

            int[] deg = new int[n + 1];
            int[] c = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                deg[i] = adj[i].size();
            }

            // Count initial red neighbors for each black node
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '0') {
                    for (int neighbor : adj[i]) {
                        if (s.charAt(neighbor - 1) == '1') {
                            c[i]++;
                        }
                    }
                }
            }

            double[][] dp = new double[n + 1][2];
            boolean[] visited = new boolean[n + 1];
            int[] parent = new int[n + 1];
            int[] order = new int[n];

            double totalExpectedOps = 0;

            // Process each black component
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '0' && !visited[i]) {
                    int orderIdx = 0;
                    int startIdx = orderIdx;

                    // 1. BFS to get topological structure & avoid StackOverflows
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    visited[i] = true;
                    parent[i] = -1;

                    while (!q.isEmpty()) {
                        int u = q.poll();
                        order[orderIdx++] = u;

                        for (int v : adj[u]) {
                            if (s.charAt(v - 1) == '0' && !visited[v]) {
                                visited[v] = true;
                                parent[v] = u;
                                q.add(v);
                            }
                        }
                    }

                    // 2. Process DP backwards (bottom-up on the tree component)
                    for (int j = orderIdx - 1; j >= startIdx; j--) {
                        int u = order[j];
                        double baseCost = 0;
                        List<Double> deltas = new ArrayList<>();

                        for (int v : adj[u]) {
                            if (s.charAt(v - 1) == '0' && parent[v] == u) {
                                baseCost += dp[v][0];
                                deltas.add(dp[v][1] - dp[v][0]);
                            }
                        }

                        Collections.sort(deltas);

                        dp[u][0] = INF;
                        dp[u][1] = INF;

                        double currentCost = baseCost;

                        for (int k = 0; k <= deltas.size(); k++) {
                            if (currentCost >= INF / 2)
                                break; // Avoid tracking past an inherently invalid sub-configuration

                            // State 0: Edge directed towards `u` from its parent (+1 to in-degree)
                            if (c[u] + 1 + k >= 1) {
                                dp[u][0] = Math.min(dp[u][0], (double) deg[u] / (c[u] + 1 + k) + currentCost);
                            }

                            // State 1: Edge directed towards parent from `u` (+0 to in-degree)
                            if (c[u] + k >= 1) {
                                dp[u][1] = Math.min(dp[u][1], (double) deg[u] / (c[u] + k) + currentCost);
                            }

                            if (k < deltas.size()) {
                                currentCost += deltas.get(k);
                            }
                        }
                    }

                    // Add the best orientation mapping for the root (who has no parent, implicitly
                    // mapping to State 1 logic).
                    totalExpectedOps += dp[i][1];
                }
            }

            out.append(String.format(Locale.US, "%.15f\n", totalExpectedOps));
        }
        System.out.print(out);
    }

    // FastReader for competitive programming performance
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}