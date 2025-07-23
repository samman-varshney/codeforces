package Unrated;

import java.util.Scanner;
import java.util.Arrays;

public class DerangedDeletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();

            int[] sorted = new int[n];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sorted[i] = arr[i];
            }
            Arrays.sort(sorted);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (sorted[i] == arr[i]) {
                    arr[i] = -1;
                } else {
                    count++;
                }
            }
            if (count == 0) {
                System.err.println("no");
            } else {
                System.err.println("yes");
                System.err.println(count);
                for (int x : arr) {
                    if (x != -1)
                        System.err.print(x + " ");

                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 3
// 2 2 3
// 5
// 4 5 5 2 4
// 1
// 1
// OutputCopy
// NO
// YES
// 4
// 4 5 2 4
// NO