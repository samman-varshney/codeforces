package Unrated;
import java.util.*;

public class YogurtSale {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int yogurt = sc.nextInt();
            int price = sc.nextInt();
            int saleprice = sc.nextInt();
            // System.out.println(yogurt);
            // System.out.println(price);
            // System.out.println(saleprice);
            if (2 * price <= saleprice) {
                System.out.println(yogurt * price);
            } else {
                int rem = yogurt % 2;
                int q = yogurt / 2;
                System.out.println(q * saleprice + rem * price);
            }
        }
        sc.close();
    }
}
