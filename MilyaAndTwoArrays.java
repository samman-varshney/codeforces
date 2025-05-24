import java.util.*;

public class MilyaAndTwoArrays {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> a = new HashMap<>();
            HashMap<Integer, Integer> b = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                set.add(x);
                a.put(x, a.getOrDefault(x, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                set.add(x);
                b.put(x, b.getOrDefault(x, 0) + 1);
            }
            if (a.size() >= 2 || b.size() >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");

            }

        }
        sc.close();
    }
}
// Example
// InputCopy
// 5
// 4
// 1 2 1 2
// 1 2 1 2
// 6
// 1 2 3 3 2 1
// 1 1 1 1 1 1
// 3
// 1 1 1
// 1 1 1
// 6
// 1 52 52 3 1 3
// 59 4 3 59 3 4
// 4
// 100 1 100 1
// 2 2 2 2
// OutputCopy
// YES
// YES
// NO
// YES
// NO