package Unrated;
import java.util.*;

public class colorBlindness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int i = 0;
            boolean isSame = true;
            while (i < n) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 == 'R' && c2 != 'R' || c2 == 'R' && c1 != 'R') {
                    isSame = false;
                    break;
                }
                i++;
            }

            if (isSame)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}
// Example
// InputCopy
// 6
// 2
// RG
// RB
// 4
// GRBG
// GBGB
// 5
// GGGGG
// BBBBB
// 7
// BBBBBBB
// RRRRRRR
// 8
// RGBRRGBR
// RGGRRBGR
// 1
// G
// G
// OutputCopy
// YES
// NO
// YES
// NO
// YES
// YES