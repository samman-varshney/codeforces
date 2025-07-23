package Rating900;
import java.util.Scanner;
public class MainakAndArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            
            int res = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                res = Math.max(arr[i] - arr[0], res);
                res = Math.max(arr[n-1]-arr[i], res);
                res = Math.max(arr[i]-arr[(i+1)%n], res);
            }

            System.out.println(res);
            
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 6
// 1 3 9 11 5 7
// 1
// 20
// 3
// 9 99 999
// 4
// 2 1 8 1
// 3
// 2 1 5
// OutputCopy
// 10
// 0
// 990
// 7
// 4