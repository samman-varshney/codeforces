package Unrated;
import java.util.*;

public class MapleandMultiplication{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == b){
                System.out.println(0);
            }else if(a%b == 0 || b%a == 0){
                System.out.println(1);
            }else{
                System.out.println(2);
            }
        }
        sc.close();
    }
}
// Example
// InputCopy
// 3
// 1 2
// 10 3
// 1000 1000
// OutputCopy
// 1
// 2
// 0