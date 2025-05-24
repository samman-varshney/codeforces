import java.util.*;

public class morningSandwich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int ans = Math.min(a - 1, b + c);
            System.out.println(2 * ans + 1);
        }
        sc.close();
    }

}
// Example
// InputCopy
// 3
// 2 1 1
// 10 1 2
// 3 7 8
// OutputCopy
// 3
// 7