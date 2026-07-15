package Rating1400;

import java.util.*;

public class D2204 {
    static List<List<Integer>> adj;

    static int getNodeCount(int u, int[] visited) {
        visited[u] = 1;
        int count = 1;

        for (int v : adj.get(u)) {
            if (visited[v] == 0) {
                count += getNodeCount(v, visited);
            }
        }

        return count;
    }

    static boolean isBipartite(int u, int[] colors, int color, int[] count) {
        colors[u] = color;
        count[color]++;
        for (int v : adj.get(u)) {
            if (colors[v] == -1) {
                if (!isBipartite(v, colors, color ^ 1, count))
                    return false;
            } else if (colors[v] == colors[u]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int[] colors = new int[n + 1];
            Arrays.fill(colors, -1);

            int total = 0;
            int[] visited = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    getNodeCount(i, visited);
                    int[] count = new int[2];
                    if (isBipartite(i, colors, 0, count))
                        total += Math.max(count[0], count[1]);
                }
            }

            System.out.println(total);
        }
        sc.close();
    }
}