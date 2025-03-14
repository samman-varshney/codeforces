import java.util.*;

public class catchCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            sc.nextInt();
            int y = sc.nextInt();
            if (y >= -1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}
// InputCopy
// 5
// 24 42
// -2 -1
// -1 -2
// 0 -50
// 15 0
// OutputCopy
// YES
// YES
// NO
// NO
// YES