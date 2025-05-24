import java.util.*;

public class ShapeParameter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int para = 4 * m;
            int sum = para;

            sc.nextInt();
            sc.nextInt();
            for (int i = 0; i < n - 1; i++) {
                int x = m - sc.nextInt();
                int y = m - sc.nextInt();
                sum += para - 2 * (x + y);
            }

            System.out.println(sum);
            System.out.println(3);
        }
        sc.close();
    }
}
// 3
// 4 3
// 1 1
// 2 2
// 2 1
// 1 2
// 1 2
// 1 1
// 6 7
// 3 6
// 1 1
// 3 1
// 6 6
// 5 4
// 6 1
