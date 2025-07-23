package Unrated;
import java.util.*;

public class stairPeakNeither {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (b > a && c > b)
                System.out.println("STAIR");
            else if (b > a && b > c)
                System.out.println("PEAK");
            else
                System.out.println("NONE");
        }
        sc.close();
    }
}
// Example
// InputCopy
// 7
// 1 2 3
// 3 2 1
// 1 5 3
// 3 4 1
// 0 0 0
// 4 1 7
// 4 5 7
// OutputCopy
// STAIR
// NONE
// PEAK
// PEAK
// NONE
// NONE
// STAIR
