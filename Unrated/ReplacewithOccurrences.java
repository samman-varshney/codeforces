
package Unrated;
import java.util.*;

public class ReplacewithOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();
            helper(n, b);
        }
        sc.close();
    }

    private static void helper(int n, int[] b) {
        int[] a = new int[n];
        int aglaNum = 1;

        Map<Integer, List<Integer>> jhund = new HashMap<>();
        for (int i = 0; i < n; i++) {
            jhund.computeIfAbsent(b[i], k -> new ArrayList<>()).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : jhund.entrySet()) {
            int v = entry.getKey();
            List<Integer> listKaIdx = entry.getValue();

            if (listKaIdx.size() % v != 0) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < listKaIdx.size(); i += v) {
                for (int j = 0; j < v; j++) {
                    a[listKaIdx.get(i + j)] = aglaNum;
                }
                aglaNum++;
            }
        }

        StringBuilder stringKiformMeAnswer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) stringKiformMeAnswer.append(' ');
            stringKiformMeAnswer.append(a[i]);
        }
        System.out.println(stringKiformMeAnswer);
    }
}
// Example
// InputCopy
// 3
// 4
// 1 2 3 4
// 6
// 1 2 2 3 3 3
// 6
// 6 6 6 6 6 6
// OutputCopy
// -1
// 4 5 5 6 6 6
// 2 2 2 2 2 2