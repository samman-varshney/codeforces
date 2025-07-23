package Unrated;

import java.util.*;

public class KingDom {
    public long helper(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n;
            n /= 2;
        }
        return sum;
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            long n = sc.nextLong();
            System.out.println(helper(n));
        }
        sc.close();
    }

    public static void main(String[] args) {
        new KingDom().solve();
    }
}

// Example
// InputCopy
// 6
// 3
// 10
// 37
// 1
// 10000000000000000
// 15
// OutputCopy
// 4
// 18
// 71
// 1
// 19999999999999980
// 26