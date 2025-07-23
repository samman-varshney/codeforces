package Unrated;
import java.util.Scanner;
public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0) {
            int a  =sc.nextInt();
            int x  =sc.nextInt();
            int y  =sc.nextInt();

            if(( x <y && a >= x && a <= y) || (x > y && a >= y && a <= x))
                System.out.println("No");
            else
                System.out.println("Yes");
        }
        sc.close();
    }
}
// Example
// InputCopy
// 3
// 1 3 4
// 5 3 1
// 3 1 5
// OutputCopy
// YES
// YES
// NO