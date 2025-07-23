package Rating1200;

import java.util.Scanner;
public class MakeAlmostEqualWithMod {
    static long gcd(long a, long b) {
        while(b != 0) {
            long temp = b;
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
            long[] arr = new long[n];
            long GCD = 0, prev  = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                if(prev == 0){
                    prev = arr[i];
                }else{
                    long diff = Math.abs(arr[i] - prev);
                    GCD = gcd(GCD, diff);
                    prev = arr[i];
                }
                
            }
             
            System.out.println(GCD*2);
            // for(int i=0; i<n; i++){
            //     System.out.print((arr[i] % (GCD*2)) + " ");
            // }
            // System.out.println();
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 4
// 8 15 22 30
// 5
// 60 90 98 120 308
// 6
// 328 769 541 986 215 734
// 5
// 1000 2000 7000 11000 16000
// 2
// 2 1
// OutputCopy
// 7
// 30
// 3
// 5000
// 1000000000000000000