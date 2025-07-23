package Rating1100;

import java.util.Scanner;
public class LiHuaandPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] grid = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    grid[i][j] = sc.nextInt();
                }
            }

            int required = 0;
            for(int i=0; i<(n+1)/2; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j] == -1)continue;

                    int rx = (n-i-1), ry = (n-1-j);
                    if(grid[i][j] !=grid[rx][ry]){
                        required++;
                    }
                    grid[rx][ry] = -1;
                }
            }

            if(required > k){
                System.out.println("NO");
            }else if((k-required)%2 == 0){
                System.out.println("YES");
            }else if(n%2 == 1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}


// Example
// InputCopy
// 3
// 4 0
// 1 1 1 1
// 0 0 0 1
// 1 0 1 0
// 1 1 1 1
// 4 3
// 1 0 1 1
// 1 0 0 0
// 0 1 0 1
// 1 1 0 1
// 5 4
// 0 0 0 0 0
// 0 1 1 1 1
// 0 1 0 0 0
// 1 1 1 1 1
// 0 0 0 0 0
// OutputCopy
// NO
// YES
// YES