package Unrated;

import java.util.*;

public class ACruelSegmentThesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            long[][] arr = new long[n][2];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextLong();
                arr[i][1] = sc.nextLong();
                ans += 2 * (arr[i][1] - arr[i][0]);
            }
            List<Integer> asc = ascending(arr);
            int m = n / 2;

            int left = 0;
            int i = 0;
            for (i = 0; i < m; i++) {
                left += -arr[asc.get(i)][1] + arr[asc.get(n - i - 1)][0];
            }
            if (n % 2 == 1) {
                left += arr[asc.get(n - i - 1)][0];
                long min = Integer.MAX_VALUE;
                for (; i < n; i++) {
                    min = Math.min(min, arr[asc.get(i)][1]);
                }
                left += -min;
            }
            System.out.println(left);
            List<Integer> desc = descending(arr);
            int right = 0;
            i = 0;
            for (i = 0; i < m; i++) {
                right += -arr[desc.get(n - i - 1)][1] + arr[desc.get(i)][0];
            }
            if (n % 2 == 1) {
                right += -arr[desc.get(n - i - 1)][1];
                long max = Integer.MIN_VALUE;
                for (; i < n; i++) {
                    max = Math.max(max, arr[desc.get(i)][0]);
                }
                right += max;
            }
            System.out.println(right);
            System.out.println(Math.max(ans + left, ans + right));

        }
        sc.close();
    }

    public static List<Integer> ascending(long[][] arr) {

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            indices.add(i);
        }

        indices.sort((i1, i2) -> {
            if (arr[i1][0] != arr[i2][0]) {
                return Long.compare(arr[i1][0], arr[i2][0]);
            } else {
                return Long.compare(arr[i1][1], arr[i2][1]);
            }
        });

        return indices;
    }

    public static List<Integer> descending(long[][] arr) {
        // Create a list of indices
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            indices.add(i);
        }

        // Sort indices based on custom comparator: b descending, then a descending
        indices.sort((i1, i2) -> {
            int cmpB = Long.compare(arr[i2][1], arr[i1][1]); // b descending
            if (cmpB != 0)
                return cmpB;
            return Long.compare(arr[i2][0], arr[i1][0]); // a descending
        });

        return indices;
    }
}

// Example
// InputCopy
// 4
// 2
// 1 1000000000
// 1 1000000000
// 3
// 1 10
// 2 15
// 3 9
// 5
// 1 11
// 2 7
// 15 20
// 1 3
// 11 15
// 1
// 1000000000 1000000000
// OutputCopy
// 2999999997
// 42
// 59
// 0
