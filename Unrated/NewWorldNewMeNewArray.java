package Unrated;
import java.util.*;

public class NewWorldNewMeNewArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = Math.abs(sc.nextInt());
            int p = sc.nextInt();

            if (k > n * p)
                System.out.println(-1);
            else
                System.out.println((int) Math.ceil(k / (p * 1.0)));
        }
        sc.close();
    }
}
// Example
// InputCopy
// 8
// 21 100 10
// 9 -420 42
// 5 -7 2
// 13 37 7
// 10 0 49
// 1 10 9
// 7 -7 7
// 20 31 1
// OutputCopy
// 10
// -1
// 4
// 6
// 0
// -1
// 1
// -1