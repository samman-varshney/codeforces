package Unrated;
import java.util.*;

public class Nikita {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == b) {
                System.out.println("yes");
            } else if (a < b) {
                System.out.println("no");
            } else {
                if ((a - b) % 2 == 0)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }
        sc.close();
    }
}
// 3
// 3 3
// 2 4
// 5 3
// OutputCopy
// Yes
// No
// Yes