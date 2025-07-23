package Unrated;
import java.util.*;

public class StringCf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            String s = sc.next();
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '1')
                    count++;

            System.out.println(count);
        }
        sc.close();
    }
}
