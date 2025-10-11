import java.util.*;

public class D2153{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++)
                nums[i] = sc.nextInt();
            
            System.out.println(makeNice(n, nums));
        }
        sc.close();
    }
    public static long makeNice(int n, int[] nums){
        long res = 1000_000_000_000_000l;
        long[] dp = new long[n];
        for(int i=0; i<3; i++){
            if(i!=0)rotate(nums, 1);
            Arrays.fill(dp, -1);
            res = Math.min(res, helper(nums.length-1, nums, dp));
        }

        return res;
    }
    public static void rotate(int[] nums, int right){
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, right-1);
        reverse(nums, right, nums.length-1);
    }
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
    public static long helper(int i, int[] nums, long[] dp){
        if(i < 0)
            return 0;
        if(i == 0)
            return 1000_000_000_000_000l;
        if(dp[i] != -1)
            return dp[i];
        //two sized block
        long b1 = helper(i-2, nums, dp)+cost(nums[i], nums[i-1]);
        //three sized block
        long b2 = i>=2?helper(i-3, nums, dp)+cost(nums[i], nums[i-1], nums[i-2]):Long.MAX_VALUE;

        return dp[i] = Math.min(b1, b2);
        
    }
    public static long cost(int x, int y){
        return Math.abs(x-y);
    }
    public static long cost(int x, int y, int z){
        int max = Math.max(x, Math.max(y, z));
        int min = Math.min(x, Math.min(y, z));
        return max - min;
    }

}
