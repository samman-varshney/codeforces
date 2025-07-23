package Unrated;
import java.util.*;

public class Fibonacciness {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int a4 = sc.nextInt();
            int a5 = sc.nextInt();
            int max = 0;
            for (int a3 = -100; a3 <= 100; a3++) {
                int fib = 0;
                if (a1 + a2 == a3)
                    fib++;
                if (a2 + a3 == a4)
                    fib++;
                if (a3 + a4 == a5)
                    fib++;
                max = Math.max(fib, max);
            }
            System.out.println(max);
        }
        sc.close();
    }
}

// 6
// 1 1 3 5
// 1 3 2 1
// 8 10 28 100
// 100 1 100 1
// 1 100 1 100
// 100 100 100 100

// 3
// 2
// 2
// 1
// 1
// 2