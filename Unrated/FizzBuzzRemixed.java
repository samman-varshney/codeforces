package Unrated;
import java.util.*;

public class FizzBuzzRemixed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            long qt = n / 15;
            long rem = n % 15 + 1;

            System.out.println(qt * 3 + (rem > 3 ? 3 : rem));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 7
// 0
// 5
// 15
// 42
// 1337
// 17101997
// 998244353
// OutputCopy
// 1
// 3
// 4
// 9
// 270
// 3420402
// 199648872