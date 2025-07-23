package Unrated;
import java.util.*;

public class SkibidusAndFanumTaxEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            @SuppressWarnings("unused")
            int n = sc.nextInt(), m = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            int b = sc.nextInt();
            if (b > 2 * nums[n - 1])
                nums[n - 1] = b - nums[n - 1];
            boolean canSort = true;
            for (int i = n - 2; i >= 0; i--) {
                if (b > 2 * nums[i] && b - nums[i] <= nums[i + 1])
                    nums[i] = b - nums[i];
                if (nums[i] > nums[i + 1])
                    nums[i] = b - nums[i];
                if (nums[i] > nums[i + 1]) {
                    canSort = false;
                    break;
                }
            }

            System.out.println(canSort ? "YES" : "NO");
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 1 1
// 5
// 9
// 3 1
// 1 4 3
// 3
// 4 1
// 1 4 2 5
// 6
// 4 1
// 5 4 10 5
// 4
// 3 1
// 9 8 7
// 8
// OutputCopy
// YES
// NO
// YES
// NO
// YES