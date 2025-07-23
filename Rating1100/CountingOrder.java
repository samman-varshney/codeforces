package Rating1100;

import java.util.Scanner;
import java.util.Arrays;
public class CountingOrder {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            int b[] = new int[n];
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                b[i] = sc.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);

            int i=n-1, j=n-1;
            long res = 1;
            while(i >= 0){
                while(j>=0 && a[j] > b[i]){
                    j--;
                }
                res = (res*(i-j))%mod;
                i--;
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
// 9 6 8 4 5 2
// 4 1 5 6 3 1
// 3
// 4 3 2
// 3 4 9
// 1s
// 2
// 1
// 3
// 2 3 4
// 1 3 3
// 12
// 2 3 7 10 23 28 29 50 69 135 420 1000
// 1 1 2 3 5 8 13 21 34 55 89 144
// OutputCopy
// 32
// 0
// 1
// 0
// 13824

