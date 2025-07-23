package Unrated;
import java.util.*;

public class ArithmeticArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += sc.nextInt();

            System.out.println(sum < n ? 1 : sum - n);
        }
        sc.close();
    }
}
