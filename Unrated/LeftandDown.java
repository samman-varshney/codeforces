package Unrated;

import java.util.Scanner;
public class LeftandDown {
    public static long GCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Optional: in case of negative numbers
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long k = sc.nextLong();

            if(a <= k && b <= k){
                System.out.println(1);
            }else{
                long gcd = GCD(a, b);
                if(k >= Math.max(a/gcd, b/gcd)){
                    System.out.println(1);
                }else{
                    System.out.println(2);
                }
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 3 5 15
// 2 3 1
// 12 18 8
// 9 7 5
// OutputCopy
// 1
// 2
// 1
// 2