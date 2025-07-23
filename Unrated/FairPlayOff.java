package Unrated;
import java.util.*;

public class FairPlayOff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int[] arr = new int[4];
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                arr[i] = sc.nextInt();
                if (max1 < arr[i]) {
                    max2 = max1;
                    max1 = arr[i];
                } else if (max2 < arr[i]) {
                    max2 = arr[i];
                }
            }
            int f1 = Math.max(arr[0], arr[1]);
            int f2 = Math.max(arr[2], arr[3]);
            if ((f1 == max1 || f1 == max2) && (f2 == max1 || f2 == max2))
                System.out.println("yes");
            else
                System.out.println("no");
        }
        sc.close();
    }
}
