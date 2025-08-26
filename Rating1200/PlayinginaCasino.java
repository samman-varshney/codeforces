package Rating1200;

import java.util.Scanner;
import java.util.Arrays;
public class PlayinginaCasino {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            long totalPot = 0;
            int[] col = new int[n];
            for (int i = 0; i < m; i++) {
                long sum = 0;
                for(int j=0; j<n; j++){
                    col[j] = arr[j][i];
                    sum += arr[j][i];
                }
                Arrays.sort(col);
                long prefixSum = 0;
                for(int j=0; j<n; j++){
                    long currSum = sum - (n - j)* 1l * col[j] - prefixSum;
                    prefixSum += col[j];
                    totalPot += currSum;
                }
            }
            System.out.println(totalPot);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 3 5
// 1 4 2 8 5
// 7 9 2 1 4
// 3 8 5 3 1
// 1 4
// 4 15 1 10
// 4 3
// 1 2 3
// 3 2 1
// 1 2 1
// 4 2 7
// OutputCopy
// 50
// 0
// 31