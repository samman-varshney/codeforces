package Unrated;
import java.util.*;
public class MaxTree {
    private static ArrayList<Integer> createTopo(ArrayDeque<Integer> q, ArrayList<Integer>[] adj, int[] indeg, int n){
        ArrayList<Integer> topo = new ArrayList<>(n);
        while (!q.isEmpty()) {
                int u = q.poll();
                topo.add(u);
                for (int w : adj[u]) {
                    indeg[w]--;
                    if (indeg[w] == 0) q.add(w);
                }
            }
        return topo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer>[] adj = new ArrayList[n+1];
            for (int i = 1; i <= n; ++i) adj[i] = new ArrayList<>();
            int[] indeg = new int[n+1];

            createAdjacency(sc, adj, indeg, n);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; ++i) if (indeg[i] == 0) q.add(i);

            ArrayList<Integer> topo = createTopo(q, adj, indeg, n);
            

            int[] p = new int[n+1];
            for (int i = 0; i < topo.size(); ++i) p[topo.get(i)] = i+1;

            for (int i = 1; i <= n; ++i) {
                out.append(p[i]);
                if (i < n) out.append(' ');
            }
            out.append('\n');
        }
        System.out.print(out.toString());
        sc.close();
    }

    private static void createAdjacency(Scanner sc, ArrayList<Integer>[] adj, int[] indeg, int n){
        for (int i = 0; i < n-1; ++i) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                long x = sc.nextLong();
                long y = sc.nextLong();
                if (x > y) {
                    // prefer p_u > p_v => v should be before u => v -> u
                    adj[v].add(u);
                    indeg[u]++;
                } else {
                    // prefer p_u < p_v => u should be before v => u -> v
                    adj[u].add(v);
                    indeg[v]++;
                }
            }
    }
}


// InputCopy
// 3
// 3
// 1 2 2 1
// 2 3 3 2
// 5
// 1 2 1 3
// 1 5 2 1
// 2 4 5 7
// 2 3 1 100
// 5
// 2 5 5 2
// 3 5 4 6
// 4 5 1 5
// 1 5 3 5
// OutputCopy
// 3 2 1 
// 2 3 5 4 1 
// 1 5 2 3 4 