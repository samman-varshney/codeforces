package Rating1200;

import java.util.Scanner;
import java.util.HashSet;
public class ThreeActivities {
    public static int solve(int[][] amax, int[][] bmax, int[][] cmax) {
        int maxSum = 0;
        int res = 0;
        HashSet<Integer> usedIndices = new HashSet<>();
        // Iterate through the top 3 elements of amax, bmax, and cmax
        // to find the maximum sum of three distinct activities
        for (int i = 0; i < 3; i++) {
            
            usedIndices.add(amax[i][1]);
            maxSum = amax[i][0];
            
            // Check combinations with bmax and cmax
            for (int j = 0; j < 3; j++) {
                if (!usedIndices.contains(bmax[j][1])) {
                    usedIndices.add(bmax[j][1]);
                    maxSum += bmax[j][0];

                    // Check combinations with cmax
                    for (int k = 0; k < 3; k++) {
                        if (!usedIndices.contains(cmax[k][1])) {
                            maxSum += cmax[k][0];
                            res = Math.max(res, maxSum);
                            maxSum -= cmax[k][0]; // Backtrack
                        }
                    }
                    usedIndices.remove(bmax[j][1]);
                    maxSum -= bmax[j][0];
                }
            }
            usedIndices.remove(amax[i][1]);
            maxSum = 0; // Reset for the next iteration
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n+1];
            int[] b = new int[n+1];
            int[] c = new int[n+1];


            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }  
            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextInt();  
            }
            for (int i = 1; i <= n; i++) {
                c[i] = sc.nextInt();
            }

            int[][][][] dp = new int[n+1][2][2][2];
            for(int i=1; i<=n; i++){
                dp[i][1][0][0] = Math.max(dp[i-1][0][1][0], Math.max(dp[i-1][0][0][1], dp[i-1][0][0][0])) + a[i];
                dp[i][0][1][0] = Math.max(dp[i-1][1][0][0], Math.max(dp[i-1][0][0][1], dp[i-1][0][0][0])) + b[i];
                dp[i][0][0][1] = Math.max(dp[i-1][0][1][0], Math.max(dp[i-1][1][0][0], dp[i-1][0][0][0])) + c[i];
                dp[i][0][0][0] = Math.max(dp[i-1][0][1][0], Math.max(dp[i-1][0][0][1], Math.max(dp[i-1][1][0][0], dp[i-1][0][0][0])));
            }

            System.out.println(Math.max(dp[n][1][0][0], Math.max(dp[n][0][1][0], Math.max(dp[n][0][0][1], dp[n][0][0][0]))));
            
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 3
// 1 10 1
// 10 1 1
// 1 1 10
// 4
// 30 20 10 1
// 30 5 15 20
// 30 25 10 10
// 10
// 5 19 12 3 18 18 6 17 10 13
// 15 17 19 11 16 3 11 17 17 17
// 1 17 18 10 15 8 17 3 13 12
// 10
// 17 5 4 18 12 4 11 2 16 16
// 8 4 14 19 3 12 6 7 5 16
// 3 4 8 11 10 8 10 2 20 3
// OutputCopy
// 30
// 75
// 55
// 56