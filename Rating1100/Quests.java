package Rating1100;

import java.util.Scanner;
public class Quests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
            for(int i=0; i<n; i++)
                b[i] = sc.nextInt();

            int sum = 0;
            int max = 0;
            int res = 0;

            for(int i=0; i< Math.min(n, k); i++){
                res = Math.max(res, Math.max(sum + a[i] + (k-i-1)*max, sum + (k-i)*max));
                max = Math.max(max, b[i]);
                sum += a[i];
            }
            if(k > n){
                res = Math.max(res, sum+(k-n-1)*max);
            }
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 4 7
// 4 3 1 2
// 1 1 1 1
// 3 2
// 1 2 5
// 3 1 8
// 5 5
// 3 2 4 1 4
// 2 3 1 4 7
// 6 4
// 1 4 5 4 5 10
// 1 5 1 2 5 1
// OutputCopy
// 13
// 4
// 15
// 15

// 1
// 3 10
// 4 8 4
// 2 9 10
