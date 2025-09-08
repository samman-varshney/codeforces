package Unrated;
import java.util.*;

public class sample{
 




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- > 0){
             int n = sc.nextInt();
        long m = sc.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int K = (int) Math.min(n, m);
        long ans = 0L;
        for (int j = 1; j <= K; ++j) {
            int x = a[n - j];
            ans += x * m;
            m--;
        }
        System.out.println(ans);
        }
        sc.close();
    }

    
}