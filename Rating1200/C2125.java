package Rating1200;
import java.util.*;

public class C2125{
    static long[][] nums = {{2, 3, 5, 7},
                    {2*3, 2*5, 3*5, 3*7, 5*7, 7*2},
                    {2*3*5, 2*3*7, 2*5*7, 3*5*7},
                    {2*3*5*7}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            long lower = helper(l-1);
            long higher = helper(r);

            System.out.println(higher - lower);
        }
        sc.close();
    }
    public static long helper(long val){
        long sub = 0;
        for(int i=0; i<4; i++){
            long[] divisors = nums[i];
            for(long d : divisors ){
                sub += (i%2==0?1:-1)*(val/d);
            }
        }
        return val - sub;
    }
}

// Example
// InputCopy
// 4
// 2 100
// 2 1000
// 13 37
// 2 1000000000000000000
// OutputCopy
// 21
// 227
// 7
// 228571428571428570