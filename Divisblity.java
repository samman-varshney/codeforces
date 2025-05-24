import java.util.*;

public class Divisblity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long ans = a % b;
            System.out.println((a + ans) % b == 0 ? ans : b - ans);

        }
        sc.close();
    }
}
// 5
// 10 4
// 13 9
// 100 13
// 123 456
// 92 46
