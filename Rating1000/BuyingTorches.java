package Rating1000;
import java.util.Scanner;
public class BuyingTorches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long x = sc.nextLong();
            long y = sc.nextLong();
            long k = sc.nextLong();
            long required = k * (y+1);
            long sticks = 0;
            while(required>1){
                sticks+=(long)required/x;
                if(required < x)
                    sticks++;
                required = (long)Math.ceil((double)required / x);
            }
            System.out.println(sticks + k);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 5
// 2 1 5
// 42 13 24
// 12 11 12
// 1000000000 1000000000 1000000000
// 2 1000000000 1000000000
// OutputCopy
// 14
// 33
// 25
// 2000000003
// 1000000001999999999