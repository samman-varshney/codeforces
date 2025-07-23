package Unrated;
import java.util.*;

public class wordGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        sc.nextLine();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            HashMap<String, Integer> map = new HashMap<>();
            String[] p1 = new String[n];
            for (int i = 0; i < n; i++) {
                p1[i] = sc.next();
                map.put(p1[i], map.getOrDefault(p1[i], 0) + 1);
            }

            String[] p2 = new String[n];
            for (int i = 0; i < n; i++) {
                p2[i] = sc.next();
                map.put(p2[i], map.getOrDefault(p2[i], 0) + 1);
            }

            String[] p3 = new String[n];
            for (int i = 0; i < n; i++) {
                p3[i] = sc.next();
                map.put(p3[i], map.getOrDefault(p3[i], 0) + 1);
            }

            int p1score = 0, p2score = 0, p3score = 0;
            for (int i = 0; i < n; i++) {
                p1score += map.get(p1[i]) < 3 ? map.get(p1[i]) == 1 ? 3 : 1 : 0;
                p2score += map.get(p2[i]) < 3 ? map.get(p2[i]) == 1 ? 3 : 1 : 0;
                p3score += map.get(p3[i]) < 3 ? map.get(p3[i]) == 1 ? 3 : 1 : 0;
            }
            System.out.println(p1score + " " + p2score + " " + p3score);
        }
        sc.close();
    }
}
// InputCopy
// 3
// 1
// abc
// def
// abc
// 3
// orz for qaq
// qaq orz for
// cod for ces
// 5
// iat roc hem ica lly
// bac ter iol ogi sts
// bac roc lly iol iat
// OutputCopy
// 1 3 1
// 2 2 6
// 9 11 5
