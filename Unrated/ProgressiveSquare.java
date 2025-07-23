package Unrated;
import java.util.Scanner;

public class ProgressiveSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            int[] b = new int[n * n];
            int sequenceSum = 0;
            for (int i = 0; i < n * n; i++) {
                b[i] = sc.nextInt();
                sequenceSum += b[i];
            }
            int totalSum = n * (d + c) * (((n - 1) * n) / 2);
            int a = (sequenceSum - totalSum) / (n * n);
            if (a * n * n != (sequenceSum - totalSum)) {
                System.out.println("NO");
            } else {
                boolean isfound = true;
                for (int x : b) {
                    if (a == x) {
                        isfound = false;
                        System.out.println("YES");
                        break;
                    }
                }
                if (isfound) {
                    System.out.println("NO");

                }
            }

        }

        sc.close();
    }
}
// 5
// 3 2 3
// 3 9 6 5 7 1 10 4 8
// 3 2 3
// 3 9 6 5 7 1 11 4 8
// 2 100 100
// 400 300 400 500
// 3 2 3
// 3 9 6 6 5 1 11 4 8
// 4 4 4
// 15 27 7 19 23 23 11 15 7 3 19 23 11 15 11 15