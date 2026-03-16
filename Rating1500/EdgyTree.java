package Rating1500;

import java.util.Scanner;

class Pair {
    int node, color;

    Pair(int node, int color) {
        this.node = node;
        this.color = color;
    }
}

public class EdgyTree {
    static long mod = (long) 1e9 + 7;
    static int[] parent, size;

    static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return;
        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }

    static int find(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] edges = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt() - 1;
            edges[i][1] = sc.nextInt() - 1;
            edges[i][2] = sc.nextInt();
        }
        System.out.println(helper(n, k, edges));
        sc.close();
    }

    static long helper(int n, int k, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (edges[i][2] == 0) {
                union(edges[i][0], edges[i][1]);
            }
        }
        long pathInComp = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                pathInComp = (pathInComp + getPaths(size[i], k)) % mod;
            }
        }

        return (getPaths(n, k) - pathInComp + mod) % mod;
    }

    static long getPaths(long num, int k) {
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * num) % mod;
        }
        return res;
    }
}
