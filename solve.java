public class solve {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getSum(new int[] { 1, 2, 3, 2, 1, 5, 6 }));
    }
}

class Solution {
    public long getSum(int[] nums) {

        int n = nums.length;
        long result = 0;

        for (int i = 0; i < n; i++) {

            // odd length palindrome
            long sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (2 * i - j < 0 || nums[2 * i - j] != nums[j])
                    break;
                sum += 2 * nums[j];
            }
            result = Math.max(result, sum);

            // even length palindrome
            if (i != n - 1 && nums[i] == nums[i + 1]) {
                sum = 2 * nums[i];
                for (int j = i + 2; j < n; j++) {
                    if (2 * i - j - 1 < 0 || nums[2 * i - j - 1] != nums[j])
                        break;
                    sum += 2 * nums[j];
                }
                result = Math.max(sum, result);
            }
        }

        return result;
    }
}
