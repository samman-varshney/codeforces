package Unrated;
import java.util.*;

public class OddSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = 2 * sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (num % 2 == 0)
                    sum++;
                else
                    sum--;
            }
            System.out.println(sum == 0 ? "yes" : "no");
        }
        sc.close();
    }
}
