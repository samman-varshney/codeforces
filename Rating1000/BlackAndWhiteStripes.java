package Rating1000;
import java.util.Scanner;
public class BlackAndWhiteStripes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            String s = sc.next();
            int prev[] = new int[n+1];

            for(int i=0; i<n; i++){
                prev[i+1] = prev[i]+(s.charAt(i)=='B'?1:0);
            }
            int res = Integer.MAX_VALUE;
            for(int i=x; i<=n; i++){
                res = Math.min(res, x - (prev[i]-prev[i-x]));
            }
            System.out.println(res);

        }
        sc.close();
    }
}
// Example
// InputCopy
// 4
// 5 3
// BBWBW
// 5 5
// BBWBW
// 5 1
// BBWBW
// 1 1
// W
// OutputCopy
// 1
// 2
// 0
// 1