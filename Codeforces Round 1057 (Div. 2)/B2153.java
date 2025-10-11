import java.util.*;

public class B2153{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            if((x&y) == (y&z) && (y&z) == (x&z))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}