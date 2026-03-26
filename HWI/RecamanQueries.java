package HWI;

import java.util.HashSet;
import java.util.Scanner;

public class RecamanQueries {
    static int[] t;
    static int[] nums;
    static HashSet<Integer> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }

        System.out.println(helper(n, q, queries));
        sc.close();
    }

    static void build(int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = nums[tl];
        } else {
            int mid = (tl + tr) / 2;
            build(2 * v, tl, mid);
            build(2 * v + 1, mid + 1, tr);

            t[v] = Math.max(t[2 * v], t[2 * v + 1]);
        }
    }

    static void update(int v, int tl, int tr, int idx, int val) {
        if (tl > idx || tr < idx) {
            return;
        } else if (tl == tr) {
            t[v] = val;
        } else {
            int mid = (tl + tr) / 2;
            update(2 * v, tl, mid, idx, val);
            update(2 * v + 1, mid + 1, tr, idx, val);

            t[v] = Math.max(t[2 * v], t[2 * v + 1]);
        }
    }

    static int query(int v, int tl, int tr, int l, int r) {
        if (tl >= l && tr <= r) {
            return t[v];
        } else if (tl > r || tr < l) {
            return Integer.MIN_VALUE;
        } else {
            int mid = (tl + tr) / 2;
            return Math.max(query(2 * v, tl, mid, l, r),
                    query(2 * v + 1, mid + 1, tr, l, r));
        }
    }

    static boolean isFortunate(int m) {
        return set.contains(m);
    }

    static long helper(int n, int q, int[][] queries) {
        t = new int[4 * n];
        build(1, 0, n - 1);
        long res = 0;
        for (int[] qy : queries) {
            if (qy[0] == 0) {
                update(1, 0, n - 1, qy[1], qy[2]);
            } else {
                int max = query(1, 0, n - 1, qy[1], qy[2]);
                int steps = getSteps(max);
                if (isFortunate(max)) {
                    res += steps * 7;
                } else {
                    res += steps;
                }
            }
        }
        return res;
    }

    static int getSteps(int m) {
        return 0;
    }
}
