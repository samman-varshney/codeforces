package Rating1200;
import java.util.*;

public class B2134{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++){
                nums[i] = sc.nextInt();
            }
            helper(n, k, nums);
        }
        sc.close();
    }
    public static void helper(int n, int k, int[] nums){
        for(int i=0; i<n; i++){
            System.out.print(nums[i] + k*1L*(nums[i]%(k+1L)) + " ");
        }
        System.out.println();
    }
}


// Example
// InputCopy
// 8
// 3 3
// 2 7 1
// 4 5
// 2 9 16 14
// 4 1
// 1 2 3 4
// 5 2
// 5 6 7 8 9
// 2 10
// 7 9
// 1 1000000000
// 1
// 1 371
// 1000000000
// 3 6
// 1 3 5
// OutputCopy
// 8 10 10
// 7 14 21 14
// 2 2 4 4
// 9 6 9 12 9
// 77 99
// 1000000000000000001
// 1000000000
// 25 15 5