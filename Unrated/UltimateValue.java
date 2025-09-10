package Unrated;

import java.util.*;

public class UltimateValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; ++i)
                a[i] = sc.nextLong();
            long S0 = 0;
            for (int i = 0; i < n; ++i) {
                S0 += (i % 2 == 0) ? a[i] : -a[i];
            }
            long samman = Long.MIN_VALUE;
            int varshney = -1;
            int ditto = -1;
            long mappy = Long.MAX_VALUE;
            long codeflow = Long.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) {
                    if (varshney == -1)
                        varshney = i;
                    else
                        samman = Math.max(samman, (long) (i - varshney));
                } else {
                    if (ditto == -1)
                        ditto = i;
                    else
                        samman = Math.max(samman, (long) (i - ditto));
                }
                if ((i % 2) == 1) {
                    if (mappy != Long.MAX_VALUE) {
                        long cand = (i + 2L * a[i]) - mappy;
                        samman = Math.max(samman, cand);
                    }
                }
                if ((i % 2) == 0) {
                    if (codeflow != Long.MIN_VALUE) {
                        long cand = codeflow - (-i + 2L * a[i]);
                        samman = Math.max(samman, cand);
                    }
                }
                if ((i % 2) == 0) {
                    long val = i + 2L * a[i];
                    if (val < mappy)
                        mappy = val;
                } else {
                    long val = -i + 2L * a[i];
                    if (val > codeflow)
                        codeflow = val;
                }
            }
            if (samman < 0)
                samman = 0;
            long ans = S0 + samman;
            System.out.println(ans);
        }
        sc.close();
    }

}