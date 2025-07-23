package Unrated;
import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int dist1 = Math.abs(a - 1);
            int dist2 = Math.abs(b - c) + Math.abs(c - 1);
            if (dist1 == dist2)
                System.out.println(3);
            else
                System.out.println(dist1 < dist2 ? 1 : 2);
        }

        sc.close();
    }
}
// InputCopy
// 3
// 1 2 3
// 3 1 2
// 3 2 1
// OutputCopy
// 1
// 3
// 2