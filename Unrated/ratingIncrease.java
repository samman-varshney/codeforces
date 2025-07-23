package Unrated;
import java.util.*;

public class ratingIncrease {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        sc.nextLine();
        while (tcase-- > 0) {
            String s = sc.nextLine();
            int i = 1, j = s.length() - 2;
            int r1 = s.charAt(i - 1) - '0', r2 = s.charAt(j + 1) - '0';
            while (i < j) {
                if (r1 > r2)
                    j--;
                else
                    i++;
                r1 = r1 * 10 + s.charAt(i) - '0';
                r2 = (s.charAt(j) - '0') * 10 + r2;

            }
            if (r1 + "" + r2 == s)
                System.out.println(r1 + " " + r2);
            else
                System.out.println(-1);
        }
        sc.close();
    }
}
// InputCopy
// 5
// 20002001
// 391125
// 200200
// 2001000
// 12
// OutputCopy
// 2000 2001
// 39 1125
// -1
// 200 1000
// 1 2