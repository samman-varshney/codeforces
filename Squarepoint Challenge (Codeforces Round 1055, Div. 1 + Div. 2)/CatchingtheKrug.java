
import java.util.*;

public class CatchingtheKrug{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            long kx = sc.nextLong();
            long ky = sc.nextLong();
            long dx = sc.nextLong();
            long dy = sc.nextLong();
          
            System.out.println(helper(n, kx, ky, dx, dy));
           
        }
        sc.close();
    }
    public static long helper(long n, long kx, long ky, long dx, long dy){
        if(kx == dx && ky == dy){
            return 0;
        }else if(kx < dx){
            long x;
            if( ky == dy){
                x = 0;
            }else if(ky < dy){
                x = dy;
            }else{
                x = n-dy;
            }
            long y = dx;
            return Math.max(x, y);
        }else if(kx > dx){
            long x;
            if( ky == dy){
                x = 0;
            }else if(ky < dy){
                x = dy;
            }else{
                x = n-dy;
            }
            long y = n - dx;
            return Math.max(x, y);
        }else{
            long x;
            if(ky < dy){
                x = dy;
            }else{
                x = n - dy;
            }
            return x;
        }

    }
}
// Example
// InputCopy
// 7
// 2 0 0 1 1
// 3 1 1 0 1
// 1 1 0 0 1
// 6 1 3 3 2
// 9 4 1 4 2
// 82 64 2 63 2
// 1000000000 500000000 500000000 1000000000 0
// OutputCopy
// 1
// 3
// 1
// 4
// 2
// 19
// 1000000000