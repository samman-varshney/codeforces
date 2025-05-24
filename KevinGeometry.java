import java.util.*;

public class KevinGeometry {

    public static long[] helper(long[] nums, long diff) {
        long prev = nums[0] == -1 ? -100000000 : nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == -1)
                continue;

            if ((nums[i] - prev) < diff)
                return new long[] { nums[i], prev };
            else
                prev = nums[i];
        }
        return new long[] {};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextLong();
            Arrays.sort(nums);

            int idx = -1;
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1)
                System.out.println(-1);
            else {
                long val = nums[idx];
                nums[idx] = nums[idx - 1] = -1l;
                long[] res = helper(nums, 2 * val);
                if (res.length == 0)
                    System.out.println(-1);
                else {
                    System.out.println(val + " " + val + " " + res[0] + " " + res[1]);
                }
            }
        }

        sc.close();
    }
}

// Example
// InputCopy
// 7
// 4
// 5 5 5 10
// 4
// 10 5 10 5
// 4
// 1 2 3 4
// 4
// 1 1 1 3
// 6
// 4 2 1 5 7 1
// 6
// 10 200 30 300 30 100
// 4
// 100000000 100000000 1 2
// OutputCopy
// 5 5 5 10
// 5 5 10 10
// -1
// -1
// 1 1 4 5
// -1
// 100000000 100000000 1 2