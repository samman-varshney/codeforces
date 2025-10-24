import java.util.*;

public class A2162{
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
    public static int helper(int n, int[] nums){
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
