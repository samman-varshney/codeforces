package Rating1500;

import java.util.*;

public class E2060 {

    static int find(int u, int[] parent) {
        if (u == parent[u])
            return u;
        return parent[u] = find(parent[u], parent);
    }

    static void union(int u, int v, int[] parent, int[] size) {
        int pu = find(u, parent);
        int pv = find(v, parent);

        if (pu == pv)
            return;
        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();

            int[][] edges1 = new int[m1][2];
            int[][] edges2 = new int[m2][2];

            for (int i = 0; i < m1; i++) {
                edges1[i][0] = sc.nextInt() - 1;
                edges1[i][1] = sc.nextInt() - 1;
            }

            for (int i = 0; i < m2; i++) {
                edges2[i][0] = sc.nextInt() - 1;
                edges2[i][1] = sc.nextInt() - 1;
            }

            int[] parent2 = new int[n];
            int[] size2 = new int[n];
            for (int i = 0; i < n; i++) {
                parent2[i] = i;
                size2[i] = 1;
            }

            for (int[] edge : edges2) {
                union(edge[0], edge[1], parent2, size2);
            }

            int ops = 0;
            int[] parent1 = new int[n];
            int[] size1 = new int[n];
            for (int i = 0; i < n; i++) {
                parent1[i] = i;
                size1[i] = 1;
            }

            // removing edges
            for (int[] edge : edges1) {
                if (find(edge[0], parent2) == find(edge[1], parent2)) {
                    union(edge[0], edge[1], parent1, size1);
                } else {
                    ops++;
                }
            }

            for (int[] edge : edges2) {
                if (find(edge[0], parent1) != find(edge[1], parent1)) {
                    union(edge[0], edge[1], parent1, size1);
                    ops++;
                }
            }

            System.out.println(ops);
        }
        sc.close();
    }
}