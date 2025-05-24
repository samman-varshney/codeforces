import java.util.*;

public class Main {

    // public static int op2(int[] dummy, int[] nums, int end) {
    // int sum = 0;
    // for (int i = 0; i < end; i++) {
    // sum += nums[i];
    // dummy[i] = nums[i + 1] - nums[i];
    // }
    // sum += nums[end];
    // return sum;
    // }

    // public static void op1(int[] dummy) {
    // int i = 0, j = dummy.length - 1;
    // while (i < j) {
    // int temp = dummy[i];
    // dummy[i] = -dummy[j];
    // dummy[j] = -temp;
    // i++;
    // j--;
    // }
    // if (dummy.length % 2 != 0)
    // dummy[dummy.length / 2] = -dummy[dummy.length / 2];
    // }

    // public static int helper(int[] nums, int end) {
    // if (0 == end)
    // return nums[0];

    // int[] dummy = new int[end];
    // int sum = op2(dummy, nums, end);
    // int nr = helper(dummy, end - 1);
    // op1(dummy);
    // int r = helper(dummy, end - 1);
    // return Math.max(nr, Math.max(sum, r));
    // }

    public static long operation(long[] nums, int end) {
        long sum = 0;
        for (int i = 0; i < end; i++) {
            nums[i] = nums[i + 1] - nums[i];
            sum += nums[i];
        }
        return sum > -sum ? sum : -sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            long[] nums = new long[n];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
                ans += nums[i];
            }

            int end = n - 1;
            while (end >= 1) {
                long afterOperation = operation(nums, end);
                ans = Math.max(ans, afterOperation);
                end--;
            }
            System.out.println(ans == Integer.MIN_VALUE ? nums[0] : ans);

        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 1
// -1000
// 2
// 5 -3
// 2
// 1000 1
// 9
// 9 7 9 -9 9 -8 7 -8 9
// 11
// 678 201 340 444 453 922 128 987 127 752 0
// OutputCopy
// -1000
// 8
// 1001
// 2056
// 269891
