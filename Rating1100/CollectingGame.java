package Rating1100;

import java.util.Scanner;
import java.util.Arrays;
public class CollectingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[][] mat = new int[n][2];
            for(int i=0; i<n; i++){
                mat[i][0] = i;
                mat[i][1] = sc.nextInt();
            }
            Arrays.sort(mat, (a, b) -> {
                return a[1] - b[1];
            });

            long sum = 0;
            int[] res = new int[n];

            for(int i=0; i<n; ){
                sum += mat[i][1];
                int j=i+1;
                while(j < n && sum >= mat[j][1]){
                    sum += mat[j][1];
                    j++;
                }
                while(i < j){
                    res[mat[i][0]] = j-1;
                    i++;
                }
            }
            for(int i=0; i<n; i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 5
// 20 5 1 4 2
// 3
// 1434 7 1442
// 1
// 1
// 5
// 999999999 999999999 999999999 1000000000 1000000000
// OutputCopy
// 4 3 0 3 1 
// 1 0 2 
// 0 
// 4 4 4 4 4 