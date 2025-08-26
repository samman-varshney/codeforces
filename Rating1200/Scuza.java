package Rating1200;

import java.util.Scanner;
public class Scuza {
    static int solve(int[] max, int x) {
        int n = max.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (max[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            int[] max = new int[n];
            long[] totalHt = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                totalHt[i] = arr[i] + (i > 0 ? totalHt[i - 1] : 0);
                max[i] = (i > 0 ? Math.max(max[i - 1], arr[i]) : arr[i]);
            }
            int[] queries = new int[q];
            for (int i = 0; i < q; i++) {
                queries[i] = sc.nextInt();
            }

            for (int i = 0; i < q; i++) {
                int idx = solve(max, queries[i]);
                if (idx == -1) {
                    System.out.print("0 ");
                } else {
                    System.out.print(totalHt[idx] + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 4 5
// 1 2 1 5
// 1 2 4 9 10
// 2 2
// 1 1
// 0 1
// 3 1
// 1000000000 1000000000 1000000000
// 1000000000
// OutputCopy
// 1 4 4 9 9 
// 0 2 
// 3000000000 