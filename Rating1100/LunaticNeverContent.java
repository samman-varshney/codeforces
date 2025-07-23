package Rating1100;

import java.util.Scanner;
public class LunaticNeverContent {
    static int gcd(int a, int b) {
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
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int res = 0;
            int i=0, j=n-1;
            while(i<j){
                int diff = Math.abs(arr[i]-arr[j]);
                res = gcd(res, diff);
                i++;j--;
            }

            System.out.println(res);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 2
// 1 2
// 8
// 3 0 1 2 0 3 2 1
// 1
// 0
// 3
// 100 1 1000000000
// OutputCopy
// 1
// 2
// 0
// 999999900