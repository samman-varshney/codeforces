package Unrated;
import java.util.*;

public class grassField {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int count = 0;
            for (int i = 0; i < 4; i++)
                count += sc.nextInt();
            if (count < 4)
                System.out.println(count == 0 ? 0 : 1);
            else
                System.out.println(2);
        }
        sc.close();
    }
}
