package Rating1000;

import java.util.Scanner;
public class CherryBomb {
    static int solve(int[] a, int[] b, int k){
        int n = a.length;
        int x = -1;
        //check if available pairs are valid
        int mina = Integer.MAX_VALUE, maxa = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                maxa = Math.max(maxa, a[i]);
                mina = Math.min(mina, a[i]);
                if(b[i]!=-1){
                    if(x == -1){
                        x = a[i]+b[i];
                    }else if (a[i]+b[i] !=x){
                        return 0;
                    }
                }
            }

            if(x!= -1){
                if(x < maxa || x - mina > k){
                    return 0;
                }
                return 1;
            }
            
            int range = maxa-mina;
            return k < range?0: k-range+1;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
               b[i] = sc.nextInt();
            }
            
            System.out.println(solve(a, b, k));
            
        }
        sc.close();
    }
}
// Example
// InputCopy
// 7
// 3 10
// 1 3 2
// -1 -1 1
// 5 1
// 0 1 0 0 1
// -1 0 1 0 -1
// 5 1
// 0 1 0 0 1
// -1 1 -1 1 -1
// 5 10
// 1 3 2 5 4
// -1 -1 -1 -1 -1
// 5 4
// 1 3 2 1 3
// 1 -1 -1 1 -1
// 5 4
// 1 3 2 1 3
// 2 -1 -1 2 0
// 5 5
// 5 0 5 4 3
// 5 -1 -1 -1 -1
// OutputCopy
// 1
// 0
// 0
// 7
// 0
// 1
// 0

// 7 2
// 1 0 0 2 1 0 1
// 1 2 2 0 1 -1 1
// 1