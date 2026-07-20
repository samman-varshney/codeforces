package Rating1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class E1702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[][] dominos = new int[n][2];
            for (int i = 0; i < n; i++) {
                dominos[i][0] = sc.nextInt();
                dominos[i][1] = sc.nextInt();
            }

            System.out.println(helper(n, dominos) ? "YES" : "NO");
        }
        sc.close();
    }

    static boolean helper(int n, int[][] dominos) {
        List<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            int[] domino = dominos[i];
            if (domino[0] == domino[1])
                return false;

            map.computeIfAbsent(domino[0], k -> new ArrayList<>()).add(i);
            map.computeIfAbsent(domino[1], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> temp : map.values()) {
            if (temp.size() > 2)
                return false;

            if (temp.size() == 2) {
                int u = temp.get(0);
                int v = temp.get(1);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }

        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, adj, colors, 0))
                    return false;
            }
        }

        return true;
    }

    static boolean dfs(int u, List<HashSet<Integer>> adj, int[] colors, int color) {
        colors[u] = color;

        for (int v : adj.get(u)) {

            if (colors[v] == -1) {
                if (!dfs(v, adj, colors, color ^ 1))
                    return false;
            } else if (colors[u] == colors[v])
                return false;
        }

        return true;
    }
}
