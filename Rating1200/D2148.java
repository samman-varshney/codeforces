package Rating1200;
import java.util.*;

public class D2148{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(helper(n, arr));
        }
        sc.close();
    }
    public static long helper(int n, int[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b-a));
        long evenSum = 0;
        for(int i=0; i<n; i++){
            if(nums[i]%2 == 0){
                evenSum += nums[i];
            }else{
                pq.offer(nums[i]);
            }
        }

        if(pq.isEmpty()){
            return 0;
        }

        int half = (pq.size()+1)/2;
        long oddSum = 0;
        while(half-- >0){
            oddSum += pq.poll();
        }
        return evenSum+oddSum;
    }
}