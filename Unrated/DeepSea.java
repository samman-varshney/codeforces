package Unrated;

import java.util.*;

public class DeepSea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            long k = sc.nextLong();
            long[] arr = new long[(int) a];
            for (long i = 0; i < a; i++)
                arr[(int) i] = sc.nextLong();

            Long left = (long) 0, right = (long) 0;
            if (k % 2 == 0) {
                left = right = k / 2;
            } else {
                left = k / 2 + 1;
                right = k / 2;
            }
            int i = 0;
            while (left > 0 && i < a) {
                if (left > arr[i]) {
                    left -= arr[i];
                    arr[i++] = 0;
                } else {
                    arr[i] -= left;
                    left = (long) 0;
                }
            }
            i = a - 1;
            while (right > 0 && i >= 0) {
                if (right > arr[i]) {
                    right -= arr[i];
                    arr[i--] = 0;
                } else {
                    arr[i] -= right;
                    right = (long) 0;
                }
            }
            i = 0;
            for (int j = 0; j < a; j++) {
                if (arr[j] == 0)
                    i++;
            }
            System.out.println(i);

        }
        sc.close();
    }
}
// 6
// 4 5
// 1 2 4 3
// 4 6
// 1 2 4 3
// 5 20
// 2 7 1 8 2
// 2 2
// 3 2
// 2 15
// 1 5
// 2 7
// 5 2