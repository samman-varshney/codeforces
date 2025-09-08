package Unrated;

import java.util.Scanner;

public class FunPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                System.out.print((n - nums[i] + 1) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 3
// 1 3 2
// 5
// 5 1 2 4 3
// 7
// 6 7 1 5 4 3 2
// OutputCopy
// 2 3 1
// 4 5 1 2 3
// 2 1 3 7 5 6 4