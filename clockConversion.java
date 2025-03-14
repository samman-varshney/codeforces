import java.util.*;

public class clockConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        sc.nextLine();
        while (tcase-- > 0) {

            String s = sc.nextLine();
            int hh = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
            if (hh == 0)
                System.out.println("12" + s.substring(2) + " AM");
            else if (hh >= 1 && hh <= 11)
                System.out.println(s + " AM");
            else if (hh == 12)
                System.out.println(s + " PM");
            else {
                String str = "0" + (hh - 12);
                int l = str.length();
                System.out.println(str.substring(l - 2) + s.substring(2) + " PM");
            }

        }
        sc.close();
    }
}
// InputCopy
// 11
// 09:41
// 18:06
// 12:14
// 00:59
// 00:00
// 14:34
// 01:01
// 19:07
// 11:59
// 12:00
// 21:37
// OutputCopy
// 09:41 AM
// 06:06 PM
// 12:14 PM
// 12:59 AM
// 12:00 AM
// 02:34 PM
// 01:01 AM
// 07:07 PM
// 11:59 AM
// 12:00 PM
// 09:37 PM
