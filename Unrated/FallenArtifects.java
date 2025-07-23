package Unrated;

import java.util.*;

public class FallenArtifects {
    public void applyGravity(char[][] grid, int n, int m) {
        for (int col = 0; col < m; col++) {
            int emptyRow = n - 1; // Track where the next '*' should fall
            for (int row = n - 1; row >= 0; row--) {
                if (grid[row][col] == 'o') {
                    emptyRow = row - 1; // Reset empty position above 'o'
                } else if (grid[row][col] == '*') {
                    if (emptyRow != row) {
                        grid[emptyRow][col] = '*';
                        grid[row][col] = '.';
                    }
                    emptyRow--; // Move the empty slot up
                }
            }
        }
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] grid = new char[n][m];

            for (int i = 0; i < n; i++) {
                grid[i] = sc.next().toCharArray();
            }

            applyGravity(grid, n, m);

            for (char[] row : grid) {
                System.out.println(new String(row));
            }
            System.out.println(); // Newline between test cases for clarity
        }
        sc.close();
    }

    public static void main(String[] args) {
        new FallenArtifects().solve();
    }
}

// Example
// InputCopy
// 3
// 6 10
// .*.*....*.
// .*.......*
// ...o....o.
// .*.*....*.
// ..........
// .o......o*
// 2 9
// ...***ooo
// .*o.*o.*o
// 5 5
// *****
// *....
// *****
// ....*
// *****
// OutputCopy
// ..........
// ...*....*.
// .*.o....o.
// .*........
// .*......**
// .o.*....o*

// ....**ooo
// .*o**o.*o

// .....
// *...*
// *****
// *****
// *****
