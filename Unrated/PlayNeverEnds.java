package Unrated;

import java.util.*;

public class PlayNeverEnds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            System.out.println(sc.nextLong() % 3 == 1 ? "YES" : "NO");
        }
        sc.close();
    }
}
