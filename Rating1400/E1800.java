package Rating1400;

import java.util.*;

public class E1800 {

    static int[] parent, size;

    static int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }

    static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }

    static void dfs(int i, int n, int k, char[] s, int[] freq, boolean[] visit) {
        freq[s[i] - 'a']++;
        visit[i] = true;
        // forword k and k + 1
        if (i + k < n && !visit[i + k]) {
            union(i, i + k);
            dfs(i + k, n, k, s, freq, visit);
        }

        if (i + k + 1 < n && !visit[i + k + 1]) {
            union(i, i + k + 1);
            dfs(i + k + 1, n, k, s, freq, visit);
        }

        if (i - k >= 0 && !visit[i - k]) {
            union(i, i - k);
            dfs(i - k, n, k, s, freq, visit);
        }

        if (i - k - 1 >= 0 && !visit[i - k - 1]) {
            union(i, i - k - 1);
            dfs(i - k - 1, n, k, s, freq, visit);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            char[] s = sc.next().toCharArray();
            char[] t = sc.next().toCharArray();

            HashMap<Integer, int[]> map = new HashMap<>();

            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            boolean[] visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    int[] freq = new int[26];
                    dfs(i, n, k, s, freq, visit);
                    map.put(find(i), freq);
                }
            }

            boolean valid = true;

            for (int i = 0; i < n; i++) {
                int pi = find(i);
                if (map.get(pi)[t[i] - 'a'] <= 0) {
                    valid = false;
                    break;
                }
                map.get(pi)[t[i] - 'a']--;
            }

            System.out.println(valid ? "YES" : "NO");

        }
        sc.close();
    }
}