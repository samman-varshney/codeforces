package Graphs_Problems;

import java.util.*;

public class Leetcode1742 {
    public static void main(String[] args) {
        DistanceLimitedPathsExist d = new DistanceLimitedPathsExist(4,
                new int[][] { { 0, 1, 5 },
                        { 0, 1, 1 },
                        { 1, 2, 2 },
                        { 2, 3, 3 } });

        int[][] queries = { { 0, 3, 2 }, { 0, 3, 3 }, { 0, 3, 4 } };
        boolean[] res = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = d.query(queries[i][0], queries[i][1], queries[i][2]);
        }

        System.out.println(Arrays.toString(res));
    }
}

class DistanceLimitedPathsExist {
    int[] parent, size;
    int[][] version;
    int[] weights;

    int find(int u) {
        if (parent[u] == u)
            return u;
        parent[u] = find(parent[u]);
        version[u][0] = parent[u];
        version[u][1] = Math.max(version[u][1], version[version[u][0]][1]);
        return parent[u];
    }

    void union(int u, int v, int ver) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;

            version[pv][0] = pu;
            version[pv][1] = ver;

        } else {
            size[pv] += size[pu];
            parent[pu] = pv;

            version[pu][0] = pv;
            version[pu][1] = ver;
        }

    }

    int lowerBound(int limit) {
        int start = 0, end = weights.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (weights[mid] < limit) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    int getParent(int u, int ver) {
        if (version[u][0] == u)
            return u;
        if (version[u][1] > ver)
            return u;
        return getParent(version[u][0], ver);
    }

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        parent = new int[n];
        size = new int[n];
        version = new int[n][2];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            version[i][0] = i;
            version[i][1] = Integer.MAX_VALUE;
        }

        Arrays.sort(edgeList, (a, b) -> (a[2] - b[2]));
        weights = new int[edgeList.length];

        for (int i = 0; i < edgeList.length; i++) {
            int u = edgeList[i][0];
            int v = edgeList[i][1];
            weights[i] = edgeList[i][2];
            union(u, v, i);
        }
    }

    boolean query(int p, int q, int limit) {
        int ver = lowerBound(limit);

        int pp = getParent(p, ver);
        int pq = getParent(q, ver);

        return pp == pq;
    }

}
