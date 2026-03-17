package Segment_Tree_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class E292 {
    static int[] a, b;
    static int[] indices;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();

        indices = new int[4 * n];
        Arrays.fill(indices, -1);

        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int k = sc.nextInt();

                update(1, 0, n - 1, x - 1, y - 1, y + k - 2);
            } else {
                int x = sc.nextInt();
                int idx = query(1, 0, n - 1, x - 1);
                if (idx == -1)
                    System.out.println(b[x - 1]);
                else
                    System.out.println(a[idx]);
            }
        }
        sc.close();

    }

    public static void update(int v, int tl, int tr, int x, int l, int r) {
        if (tl >= l && tr <= r) {
            indices[v] = x + (tl - l);
        } else if (tl > r || tr < l) {
            return;
        } else {
            push(v, tl, tr);
            int mid = (tl + tr) / 2;
            update(2 * v, tl, mid, x, l, r);
            update(2 * v + 1, mid + 1, tr, x, l, r);
        }
    }

    static int query(int v, int tl, int tr, int idx) {

        if (tl == tr || indices[v] != -1) {
            if (indices[v] == -1)
                return -1;
            return indices[v] + (idx - tl);
        } else {
            push(v, tl, tr);
            int mid = (tl + tr) / 2;
            if (idx <= mid)
                return query(2 * v, tl, mid, idx);
            else
                return query(2 * v + 1, mid + 1, tr, idx);
        }
    }

    static void push(int v, int l, int r) {
        if (indices[v] != -1) {
            int mid = (l + r) / 2;
            indices[2 * v] = indices[v];
            indices[2 * v + 1] = indices[v] + (mid - l + 1);
            indices[v] = -1;
        }
    }
}
