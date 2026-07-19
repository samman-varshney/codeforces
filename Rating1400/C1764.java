package Rating1400;

import java.util.Arrays;
import java.util.Scanner;

public class C1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums);
            long result = 0;
            int i = 0;
            while (i < n) {
                int j = i;
                while (j < n && nums[i] == nums[j]) {
                    j++;
                }

                i = j;
                long edges = i * 1L * (n - i);
                result = Math.max(result, edges);
            }

            if (result == 0) {
                System.out.println(n / 2);
            } else {
                System.out.println(result);
            }
        }
        sc.close();
    }
}
