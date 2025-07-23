package Unrated;
import java.util.Scanner;

public class GraphComposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int[][] v = new int[n][n];
            int sum = 0;
            for (int i = 0; i < m1; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                v[x - 1][y - 1] = 1;
                v[y - 1][x - 1] = 1;
                sum++;
            }

            for (int i = 0; i < m2; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (v[x - 1][y - 1] == 1) {
                    sum--;
                } else {
                    sum++;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }

}
// Example
// InputCopy
// 5
// 3 2 1
// 1 2
// 2 3
// 1 3
// 2 1 1
// 1 2
// 1 2
// 3 2 0
// 3 2
// 1 2
// 1 0 0
// 3 3 1
// 1 2
// 1 3
// 2 3
// 1 2
// OutputCopy
// 3
// 0
// 2
// 0
// 2

// 20 19 6
// 5 7
// 9 2
// 6 8
// 4 1
// 6 3
// 14 3
// 8 10
// 4 11
// 1 5
// 3 1
// 11 17
// 15 11
// 7 18
// 2 13
// 2 1
// 12 7
// 19 7
// 20 7
// 16 4
// 19 6
// 15 7
// 6 10
// 1 20
// 3 10
// 12 15