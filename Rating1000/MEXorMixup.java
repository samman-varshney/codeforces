package Rating1000;
import java.util.Scanner;
public class MEXorMixup {
    static int xor_upto_n(int n) {
    if (n % 4 == 0) return n;
    else if (n % 4 == 1) return 1;
    else if (n % 4 == 2) return n + 1;
    else return 0;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int mex = sc.nextInt();
            int xor = sc.nextInt();

            int len = mex;
            int axor = xor_upto_n(mex-1);
            System.out.println(axor);

            if(axor == xor){
                System.out.println(len);
            }else if(xor!=mex){
                System.out.println(len + 1);
            }else{
                System.out.println(len + (axor==0?2:1));
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 1 1
// 2 1
// 2 0
// 1 10000
// 2 10000
//169234 169235
// OutputCopy
// 3
// 2
// 3
// 2
// 3