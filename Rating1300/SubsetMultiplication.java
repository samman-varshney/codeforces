package Rating1300;

import java.util.Scanner;
public class SubsetMultiplication {
     public static int GCD(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int a = 0;
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i]  = sc.nextInt();
                a = GCD(a, arr[i]);
            }
            for(int i=0; i<n; i++){
                arr[i] = arr[i]/a;
            }
            for(int i=0; i<n; i++){
                
            }
            // int ans = gcd/a;
            // System.out.println(ans == 0?1:ans);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 4
// 2
// 2 4
// 3
// 1 1000000000 500000000
// 4
// 4 8 4 8
// 7
// 42 42 14 84 28 73080 255780
// OutputCopy
// 343
// 2
// 4
// 6