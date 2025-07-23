package Unrated;
import java.util.*;

public class upScaling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < 2; j++) {
                        for (int k = 0; k < n; k++)
                            if (k % 2 == 0)
                                System.out.print("##");
                            else
                                System.out.print("..");
                        System.out.println();
                    }
                } else {
                    for (int j = 0; j < 2; j++) {
                        for (int k = 0; k < n; k++)
                            if (k % 2 == 0)
                                System.out.print("..");
                            else
                                System.out.print("##");
                        System.out.println();
                    }
                }
            }
        }
        sc.close();
    }
}
// 4
// 1
// 2
// 3
// 4
// ##
// ##
// ##..
// ##..
// ..##
// ..##
// ##..##
// ##..##
// ..##..
// ..##..
// ##..##
// ##..##
// ##..##..
// ##..##..
// ..##..##
// ..##..##
// ##..##..
// ##..##..
// ..##..##
// ..##..##