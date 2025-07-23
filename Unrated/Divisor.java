package Unrated;
import java.util.Scanner;
public class Divisor {
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static long nextPrime(long n) {
        if (n <= 1) return 2;
        long next = n;
        while (true) {
            if (isPrime(next)) {
                return next;
            }
            next++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0) {
            long d = sc.nextLong();
            long d1 = nextPrime(d+1);
            long d2 = nextPrime(d1+d);
            System.out.println(d1*d2);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 2
// 1
// 2
// OutputCopy
// 6
// 15
