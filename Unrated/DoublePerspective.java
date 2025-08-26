package Unrated;

import java.util.*;

public class DoublePerspective {
    // Function to filter out intervals completely covered by others
    public static int[][] filterCompletelyOverlapped(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return -Integer.compare(a[1], b[1]); // Longer interval comes first if same start
        });

        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        result.add(prev);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // If current is completely covered by prev, skip it
            if (curr[0] >= prev[0] && curr[1] <= prev[1]) {
                continue;
            } else {
                result.add(curr);
                prev = curr;
            }
        }

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i; // store original index
            }

            // Work only with start, end; keep index mapping
            int[][] temp = new int[n][2];
            for (int i = 0; i < n; i++) {
                temp[i][0] = intervals[i][0];
                temp[i][1] = intervals[i][1];
            }

            int[][] merged = filterCompletelyOverlapped(temp);

            // Mark which intervals were kept
            Set<String> kept = new HashSet<>();
            for (int[] m : merged) {
                kept.add(m[0] + "#" + m[1]);
            }

            // Collect original indices of kept intervals
            List<Integer> finalIndices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String key = intervals[i][0] + "#" + intervals[i][1];
                if (kept.contains(key)) {
                    finalIndices.add(intervals[i][2]);
                }
            }

            // Sort indices for consistent output
            Collections.sort(finalIndices);
            System.err.println(finalIndices.size());
            for (int idx : finalIndices) {
                System.out.print((idx + 1)+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// Example
// InputCopy
// 2
// 1
// 1 2
// 4
// 1 2
// 2 3
// 1 3
// 3 5
// OutputCopy
// 1
// 1
// 3
// 1 2 4