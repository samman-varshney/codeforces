package Rating1600;

import java.util.*;

public class C2063 {

    static int[][] onesGroup, twosGroup;

    static void dfs(int u, int p, List<List<Integer>> adj) {
        int size = adj.get(u).size() + (p == -1 ? 0 : -1);
        if (size == 0) {
            onesGroup[u][0] = u;
            onesGroup[u][1] = 0;

            twosGroup[u][0] = u;
            twosGroup[u][1] = -1;
            return;
        }

        int twos = -1;
        int ones1 = -1;
        int ones2 = -1;

        for (int v : adj.get(u)) {
            if (v != p) {
                dfs(v, u, adj);

                if (twos == -1 || twosGroup[twos][1] < twosGroup[v][1]
                        || (twosGroup[twos][1] == twosGroup[v][1] && twosGroup[v][0] == v)) {
                    twos = v;
                }

                if (ones1 == -1 || onesGroup[ones1][1] < onesGroup[v][1]
                        || (onesGroup[ones1][0] == onesGroup[v][1] && onesGroup[v][0] == v)) {
                    ones2 = ones1;
                    ones1 = v;
                } else if (ones2 == -1 || onesGroup[ones2][1] < onesGroup[v][1]
                        || (onesGroup[ones2][0] == onesGroup[v][1] && onesGroup[v][0] == v)) {
                    ones2 = v;
                }
            }
        }

        if (size > onesGroup[ones1][1]) {
            onesGroup[u][0] = u;
            onesGroup[u][1] = size;
        } else {
            onesGroup[u][0] = onesGroup[ones1][0];
            onesGroup[u][1] = onesGroup[ones1][1] + (onesGroup[ones1][0] == ones1 ? 1 : 0);
        }

        if (size - 1 + onesGroup[ones1][1] >= twosGroup[twos][1] + (twosGroup[twos][0] == twos ? 1 : 0) &&
                (size - 1 + onesGroup[ones1][1] >= onesGroup[ones1][1] + (ones2 != -1 ? onesGroup[ones2][1] : 0)
                        + (onesGroup[ones1][0] == ones1 && (ones2 != -1 && onesGroup[ones2][0] == ones2) ? 1
                                : onesGroup[ones1][0] != ones1 && (ones2 != -1 && onesGroup[ones2][0] != ones2) ? -1
                                        : 0))) {
            twosGroup[u][0] = u;
            twosGroup[u][1] = size - 1 + onesGroup[ones1][1];
        } else if (twosGroup[twos][1] + (twosGroup[twos][0] == twos ? 1 : 0) > size - 1 + onesGroup[ones1][1] &&
                (twosGroup[twos][1] + (twosGroup[twos][0] == twos ? 1 : 0) > onesGroup[ones1][1]
                        + (ones2 != -1 ? onesGroup[ones2][1] : 0)
                        + (onesGroup[ones1][0] == ones1 && (ones2 != -1 && onesGroup[ones2][0] == ones2) ? 1
                                : onesGroup[ones1][0] != ones1 && (ones2 != -1 && onesGroup[ones2][0] != ones2) ? -1
                                        : 0))) {
            twosGroup[u][0] = twos;
            twosGroup[u][1] = twosGroup[twos][1] + (twosGroup[twos][0] == twos ? 1 : 0);
        } else {
            twosGroup[u][0] = ones1;
            twosGroup[u][1] = onesGroup[ones1][1] + (ones2 != -1 ? onesGroup[ones2][1] : 0)
                    + (onesGroup[ones1][0] == ones1 && (ones2 != -1 && onesGroup[ones2][0] == ones2) ? 1
                            : onesGroup[ones1][0] != ones1 && (ones2 != -1 && onesGroup[ones2][0] != ones2) ? -1
                                    : 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taces = sc.nextInt();
        while (taces-- > 0) {
            int n = sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;

                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            onesGroup = new int[n][2];
            twosGroup = new int[n][2];
            dfs(0, -1, adj);

            System.out.println(twosGroup[0][1]);
        }
        sc.close();
    }
}
