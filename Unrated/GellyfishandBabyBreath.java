package Unrated;
import java.util.Scanner;
public class GellyfishandBabyBreath {
    static int mod = 998244353;
    public static long binaryExponantiation(int a){
        long res = 1;
        long base = 2;
        while(a > 0){
            if((a&1) == 1)
                res = (res*base)%mod;
            base =(base*base)%mod;
            a/=2;
        }
        return res;
    }
    public static long compute(int a, int b){
        long ar2 = binaryExponantiation(a);
        long br2 = binaryExponantiation(b);
        return (ar2 + br2)%mod;
    }
    public static String compare(int[] a, int[] b){
        if(a[0] != b[0])
            return (a[0]>b[0]?compute(a[0], a[1]):compute(b[0], b[1]))+" ";
        return (a[1]>b[1]?compute(a[0], a[1]):compute(b[0], b[1]))+" ";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
            for(int i=0; i<n; i++)
                b[i] = sc.nextInt();

            int ai = 0, bi = 0;
            int i = 0;
            while(i<n){
                if(a[ai] < a[i])
                    ai = i;
                if(b[bi] < b[i])
                    bi = i;
                
                System.out.print( compare(new int[]{a[ai], b[i-ai]}, new int[]{b[bi], a[i-bi]}) );
                i++;
            }
            System.out.println();
        }
        sc.close();
    }
}


// Example
// InputCopy
// 3
// 3
// 0 2 1
// 1 2 0
// 5
// 0 1 2 3 4
// 4 3 2 1 0
// 10
// 5 8 9 3 4 0 2 7 1 6
// 9 5 1 4 0 3 2 8 7 6
// OutputCopy
// 3 6 8 
// 17 18 20 24 32 
// 544 768 1024 544 528 528 516 640 516 768 