package Rating1200;
import java.util.*;

public class D2126{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int coins = sc.nextInt();
            int[][] casinos = new int[n][3];
            for(int i=0; i<n; i++){
                casinos[i][0] = sc.nextInt();
                casinos[i][1] = sc.nextInt();
                casinos[i][2] = sc.nextInt();
            }
            System.out.println(maxCoins(n, coins, casinos));
        }
        sc.close();
    }

    public static int maxCoins(int n, int coins, int[][] casinos){
        int[][] intervals = new int[n][2];
        for(int i=0; i<n; i++){
            intervals[i][0] = casinos[i][0];
            intervals[i][1] = casinos[i][2];
        }
        Arrays.sort(intervals, (a, b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });

        for(int[] interval : intervals){
            if(coins >= interval[0] && coins <= interval[1])
                return interval[1];
        }
        return coins;
    }

}

// Example
// InputCopy
// 5
// 3 1
// 2 3 3
// 1 2 2
// 3 10 10
// 1 0
// 1 2 2
// 1 2
// 1 2 2
// 2 2
// 1 3 2
// 2 4 4
// 2 5
// 1 10 5
// 3 6 5
// OutputCopy
// 10
// 0
// 2
// 4
// 5