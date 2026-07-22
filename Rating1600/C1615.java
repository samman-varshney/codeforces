package Rating1600;

import java.util.Scanner;

public class C1615 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            char[] a = sc.next().toCharArray();
            char[] b = sc.next().toCharArray();

            System.out.println(helper(n, a, b));
        }
        sc.close();
    }

    static int helper(int n, char[] a, char[] b) {
        int onesA = 0, onesB = 0;
        for (int i = 0; i < n; i++) {
            onesA += a[i] - '0';
            onesB += b[i] - '0';
        }

        if (onesA != onesB && onesB != (n - onesA) + 1)
            return -1;

        int swapped = 0;
        if (onesB == (n - onesA) + 1 && onesA != onesB) {
            onesA += 1;
            swapped = 1;
            for (int i = 0; i < n; i++) {
                if (a[i] == b[i] && a[i] == '1')
                    continue;
                a[i] = a[i] == '0' ? '1' : '0';
            }
        }

        // direct conversion
        int mismatchedLits = 0;
        for (int i = 0; i < n; i++) {
            mismatchedLits += a[i] == '1' && a[i] != b[i] ? 1 : 0;
        }

        int directConversion = mismatchedLits * 2 + swapped;

        // swap and conversion
        int inDirectConversion = Integer.MAX_VALUE;
        if (onesA - 1 == n - onesA) {
            int matchedLits = 0;
            for (int i = 0; i < n; i++) {
                matchedLits += a[i] == b[i] && a[i] == '1' ? 1 : 0;
            }

            inDirectConversion = swapped + 1 + (matchedLits - 1) * 2;
        }

        return Math.min(directConversion, inDirectConversion);
    }
}