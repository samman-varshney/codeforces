package Rating1000;
import java.util.Scanner;
public class JohnnyandAncientComputer {
    public static long helper(long a, long b){

        if(b%a == 0){
                long c = b / a;
                long ans = 0;
                while(c > 1) {
                    if(c%2 != 0)
                        return -1;
                    c /= 2;
                    ans++;
                }
                return (long)Math.ceil(ans/3.0);
        }else if(a%b == 0) {
                long c = a / b;
                long ans = 0;
                while(c > 1) {
                    if(c%2 != 0)
                        return -1;
                    c /= 2;
                    ans++;
                }
                return (long)Math.ceil(ans/3.0);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            System.out.println(helper(a, b));
        }
        sc.close();
    }
}
// Example
// InputCopy
// 10
// 10 5
// 11 44
// 17 21
// 1 1
// 96 3
// 2 128
// 1001 1100611139403776
// 1000000000000000000 1000000000000000000
// 7 1
// 10 8
// OutputCopy
// 1
// 1
// -1
// 0
// 2
// 2
// 14
// 0
// -1
// -1