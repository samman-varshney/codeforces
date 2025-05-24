import java.util.*;

public class FarmerJohnsCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] v = new int[n][m];
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    v[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.sort(v[i]);
            }

            int[] check = new int[n];
            for (int i = 0; i < n; i++) {
                if (v[i][0] < n) {
                    check[v[i][0]] = i + 1;
                } else {
                    System.out.println(-1);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }

            int val = n;
            outer: for (int j = 1; j < m; j++) {
                for (int i : check) {
                    if (v[i - 1][j] != val) {
                        System.out.println(-1);
                        flag = true;
                        break outer;
                    }
                    val++;
                }
            }

            if (flag) {
                continue;
            }

            for (int i = 0; i < check.length; i++) {
                System.out.print(check[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}