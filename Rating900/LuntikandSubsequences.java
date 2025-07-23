package Rating900;
import java.util.Scanner;
public class LuntikandSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int  n = sc.nextInt();
            int zero = 0;
            int one =0;
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                if(num == 0)
                    zero++;
                else if(num == 1)
                    one++;
            }
            if(zero == n)
                System.out.println(0);
            else
                System.out.println((long)(one*Math.pow(2, zero)));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 5
// 1 2 3 4 5
// 2
// 1000 1000
// 2
// 1 0
// 5
// 3 0 2 1 1
// 5
// 2 1 0 3 0
// OutputCopy
// 1
// 0
// 2
// 4
// 4