package Rating1200;

import java.util.Scanner;
public class PlusMinusPermutation {
    static long gcd(long a, long b) {
        while( b != 0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    static long LCM(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long lcm = LCM(x, y);
            long m = n - n/x + n/lcm;
            long p = n/y - n/lcm;

            long sum = (n*(n+1))/2 - (m*(m+1))/2 - (p*(p+1))/2;
            System.out.println(sum);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 8
// 7 2 3
// 12 6 3
// 9 1 9
// 2 2 2
// 100 20 50
// 24 4 6
// 1000000000 5575 25450
// 4 4 1
// OutputCopy
// 12
// -3
// 44
// 0
// 393
// 87
// 179179179436104
// -6