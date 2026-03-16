package Segment_Tree_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class A356 {
    static boolean[] t;
    static int[] res;

    static void update(int v, int tl, int tr, int l, int r, int val) {
        if (l > tr || r < tl || !t[v] || (val == tl && val == tr)) {
            return;
        } else if (tl == tr) {
            res[tl] = val;
            t[v] = false;
        } else {
            int mid = (tl + tr) / 2;
            update(2 * v, tl, mid, l, r, val);
            update(2 * v + 1, mid + 1, tr, l, r, val);
            t[v] = t[2 * v] || t[2 * v + 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        t = new boolean[4 * n];
        Arrays.fill(t, true);

        res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            l--;
            r--;
            x--;

            update(1, 0, n - 1, l, r, x);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + 1 + " ");
        }
        System.out.println();
        sc.close();
    }
}

// core idea is that if a segment is dead thn stop propagation else keep going
// until
// you find then leaf node and mark the same in res too.

// https://www.notion.so/Segment-Tree-320a725173d78035a581d32ac9ab4ece