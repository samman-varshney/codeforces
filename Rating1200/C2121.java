package Rating1200;
import java.util.*;

public class C2121{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] grid = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println(helper(n, m, grid));
        }
        sc.close();
    }
    public static int helper(int n, int m, int[][] grid){
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == max){
                    rows.put(i, rows.getOrDefault(i, 0)+1);
                    cols.put(j, cols.getOrDefault(j, 0)+1);
                    count++;
                }
            }
        }
        int rowMax = 0;
        int rowCount = -1;
        for(int row: rows.keySet()){
            if(rowCount < rows.get(row)){
                rowCount = rows.get(row);
                rowMax = row;
            }
        }
        int colMax = 0;
        int colCount = -1;
        for(int col : cols.keySet()){
            if(colCount < cols.get(col)){
                colCount = cols.get(col);
                colMax = col;
            }
        }

        if((rowCount + colCount + (grid[rowMax][colMax]==max?-1:0)) == count)
            return max-1;
        
        return max;
    }
}


// Example
// InputCopy
// 10
// 1 1
// 1
// 1 2
// 1 2
// 2 1
// 2
// 1
// 2 2
// 4 2
// 3 4
// 3 4
// 1 2 3 2
// 3 2 1 3
// 2 1 3 2
// 4 3
// 1 5 1
// 3 1 3
// 5 5 5
// 3 5 1
// 4 4
// 1 3 3 2
// 2 3 2 2
// 1 2 2 1
// 3 3 2 3
// 2 2
// 2 2
// 1 2
// 3 2
// 1 2
// 2 1
// 1 2
// 3 3
// 2 1 1
// 1 2 1
// 1 1 2
// OutputCopy
// 0
// 1
// 1
// 3
// 2
// 4
// 3
// 1
// 1
// 2