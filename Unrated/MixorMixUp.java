package Unrated;
import java.util.Scanner;
public class MixorMixUp {
    public static int XorOfSeq(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int mex = sc.nextInt();
            int xor = sc.nextInt();
            
            int xorofmex = XorOfSeq(mex-1);
            if(xorofmex == xor) {
                System.out.println(mex);
            }else if((xor^xorofmex) != mex){
                System.out.println(mex+1);
            }else{
                System.out.println(mex+2);
                
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
// OutputCopy
// 3
// 2
// 3
// 2
// 3