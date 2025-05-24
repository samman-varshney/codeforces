package Rating900;
import java.util.Scanner;
import java.util.Arrays;
public class BalancedRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int res = 1;
            int count = 1;
            for(int i=1; i<n; i++){
                if(arr[i]-arr[i-1] <= k){
                    count++;
                }else{
                    res = Math.max(res, count);
                    count=1;
                }
            }
            res = Math.max(res, count);
            System.out.println(n - res);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 7
// 5 1
// 1 2 4 5 6
// 1 2
// 10
// 8 3
// 17 3 1 20 12 5 17 12
// 4 2
// 2 4 6 8
// 5 3
// 2 3 19 10 8
// 3 4
// 1 10 5
// 8 1
// 8 3 1 4 5 10 7 3
// OutputCopy
// 2
// 0
// 5
// 0
// 3
// 1
// 4