package Rating1200;
import java.util.*;

public class A2135{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++)
                nums[i] = sc.nextInt();
            
            System.out.println(helper(n, nums));
        }
        sc.close();
    }
    public static int helper(int n, int[] nums)
    {
        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        int[] index = new int[n];

        for(int i=0; i<n; i++){
            int num = nums[i];
            if(num == 1){
                index[i] = i;
                continue;
            }
            Deque<Integer> deque = map.computeIfAbsent(num, k -> new ArrayDeque<>());
            if(deque.size() == num-1){
                index[i] = deque.pollFirst();
            }else{
                index[i] = -1;
            }
            deque.addLast(i);
        }
        int[] dp = new int[n];
        int prev = 0;
        int res = 0;
        for(int i=0; i<n; i++){
            
            int block = 0;
            if(index[i] != -1) {
                block = (index[i]==0?0:dp[index[i]-1])+nums[i];
            }
            dp[i] = Math.max(block, prev);
        
            prev = dp[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// Example
// InputCopy
// 6
// 1
// 1
// 2
// 2 2
// 4
// 2 2 1 1
// 6
// 1 2 3 3 3 1
// 8
// 8 8 8 8 8 8 8 7
// 10
// 2 3 3 1 2 3 5 1 1 7
// OutputCopy
// 1
// 2
// 4
// 5
// 0
// 5

//3
//2 2 2