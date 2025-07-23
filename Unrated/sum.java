package Unrated;
import java.util.*;

public class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a + b == c || a + c == b || b + c == a)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}
