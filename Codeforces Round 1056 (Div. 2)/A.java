import java.util.*;

public class A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int a = n, b = n-1;
            int win = 0;
            while(a > 1){
                win += a/2;
                a = (a+1)/2;
            }
            int lose = 0;
            while(b > 1){
                lose += b/2;
                b = (b+1)/2;
            }

            System.out.println(win+lose+1);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 2
// 2
// 3
// OutputCopy
// 2
// 4