import java.util.*;

public class Officals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer>[] tree = new ArrayList[n + 1]; // Adjacency list
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        List<Integer> roots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int p = sc.nextInt();
            if (p == -1) {
                roots.add(i); // No superior, root of a tree
            } else {
                tree[p].add(i); // Build tree
            }
        }

        // Find max depth using BFS
        int maxDepth = 0;
        for (int root : roots) {
            maxDepth = Math.max(maxDepth, bfs(root, tree));
        }

        System.out.println(maxDepth);
        sc.close();
    }

    private static int bfs(int root, List<Integer>[] tree) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { root, 1 }); // Node, Depth
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int current = node[0], depth = node[1];
            maxDepth = Math.max(maxDepth, depth);

            for (int child : tree[current]) {
                queue.add(new int[] { child, depth + 1 });
            }
        }

        return maxDepth;

    }
}

// Examples
// InputCopy
// 5
// -1
// 1
// 2
// 1
// -1
// OutputCopy
// 3