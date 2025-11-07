import java.util.HashMap;

public class sample {




 public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static long LCM(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        long gcdValue = gcd(a, b);
   
        long product = Math.abs(a / gcdValue) * Math.abs(b);
        
        return product;
    }
    public static long helper(long d1, long d2, long c1, long c2){
        long lcm = LCM(c1, c2);
        long q = (d1+d2)/(lcm-1) ;
        long sam = q*lcm;
        long rem = (d1+d2 - q*(lcm-1));
        long time = sam + (rem==0?-1:rem);
        return time;
    }

    public static void main(String[] args) {
        System.out.println(helper(1, 3, 2, 2));
        System.out.println(helper(2, 1, 3, 4));
        System.out.println(helper(5, 4, 2, 3));
        System.out.println(helper(3, 1, 2, 3));
    }
}
