package Rating1100;

import java.util.*;

public class C2131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] s = new int[n];
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                t[i] = sc.nextInt();
            }

            System.out.println(helper(n, k, s, t));
        }
        sc.close();
    }

    public static String helper(int n, int k, int[] s, int[] t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s[i] % k, map.getOrDefault(s[i] % k, 0) + 1);
            map.put(k - (s[i] % k), map.getOrDefault(k - (s[i] % k), 0) + 1);
            map.put(t[i] % k, map.getOrDefault(t[i] % k, 0) - 1);
            map.put(k - (t[i] % k), map.getOrDefault(k - (t[i] % k), 0) - 1);
        }
        for (int i : map.values()) {
            if (i != 0) {
                return "NO";
            }
        }
        return "YES";
    }
}

// Example
// InputCopy
// 5
// 1 3
// 1
// 2
// 1 8
// 4
// 12
// 3 5
// 6 2 9
// 8 4 11
// 2 7
// 2 8
// 2 9
// 3 2
// 0 1 0
// 1 0 1
// OutputCopy
// YES
// YES
// YES
// NO
// NO