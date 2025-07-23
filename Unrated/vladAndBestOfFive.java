package Unrated;
import java.util.*;

public class vladAndBestOfFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        sc.nextLine();
        while (tcase-- > 0) {
            String s = sc.nextLine();
            int a = 0;
            int b = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'A')
                    a++;
                else {
                    b++;
                }
            }
            System.out.println(a > b ? 'A' : 'B');
        }
        sc.close();
    }
}
// InputCopy
// 8
// ABABB
// ABABA
// BBBAB
// AAAAA
// BBBBB
// BABAA
// AAAAB
// BAAAA
// OutputCopy
// B
// A
// B
// A
// B
// A
// A
// A
