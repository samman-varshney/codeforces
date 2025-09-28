package Unrated;

import java.util.*;

public class ReplacewithOccurrences {
    static HashMap<Long, Long> map;
    static int minHeight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nodes = new int[n-1];
            for(int i=0; i<n-1; i++){
                nodes[i] = sc.nextInt();
            }
            map = new HashMap<>();
            minHeight = Integer.MAX_VALUE;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0; i<=n; i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0; i<n-1; i++){
                adj.get(nodes[i]).add(i+2);
            }

            helper(adj, 1, 1);
            int ans = 0;
            Long[] arr = new Long[minHeight];
            for(int i=0; i<minHeight; i++){
                arr[i] = map.getOrDefault((long)(i+1), 0L);
            }
            // first choose up to min(k, n-k), then remaining with other capacity
            int[] arrInt = new int[minHeight];
            for (int i = 0; i < minHeight; i++) {
                arrInt[i] = arr[i].intValue();
            }
            List<Integer> res = findBestSubsequenceIndices(arrInt, Math.min((long)k, (long)(n-k)));
            ans += res.size();
            for(int i: res){
                arr[i] = Long.MAX_VALUE; // mark as used (large so won't be picked again)
            }
            int[] arrInt2 = new int[minHeight];
            for (int i = 0; i < minHeight; i++) {
                arrInt2[i] = arr[i].intValue();
            }
            res = findBestSubsequenceIndices(arrInt2, Math.max((long)k, (long)(n-k)));
            ans += res.size();
            System.out.println(ans);
        }
        sc.close();
    }

    private static void helper(ArrayList<ArrayList<Integer>> adj, int node, int height) {
        map.put((long)height, map.getOrDefault((long)height, 0L) + 1);
        if (adj.get(node).size() == 0) {
            minHeight = Math.min(height, minHeight);
        }
        for (int child : adj.get(node)) {
            helper(adj, child, height + 1);
        }
    }

    // ---------- Data holders ----------
   

    private static class PrevLong {
        final long prevSum;
        final int index;
        PrevLong(long prevSum, int index) {
            this.prevSum = prevSum;
            this.index = index;
        }
    }

    /**
     * Returns a list of indices (0-based, in original order) representing a
     * subsequence with:
     * - maximum length such that sum <= limit
     * - among those with max length, maximum possible sum
     *
     * Uses the fast BitSet-backed DP when limit fits in int, otherwise falls back
     * to a long-safe HashMap DP.
     */
    public static List<Integer> findBestSubsequenceIndices(int[] arr, long limit) {
        if (limit <= 0 || arr.length == 0) return new ArrayList<>();

        // If limit fits in int, use fast BitSet-based DP (int indices).
        if (limit <= Integer.MAX_VALUE) {
            return findBestWithIntLimit(arr, (int) limit);
        } else {
            // fallback: long-safe DP using HashMaps (slower)
            return findBestWithLongLimit(arr, limit);
        }
    }

    // ---------------- Fast Int (BitSet) implementation ----------------
    private static List<Integer> findBestWithIntLimit(int[] arr, int limit) {
        int n = arr.length;
        if (n == 0 || limit <= 0) return new ArrayList<>();

        // prepare usable items (skip non-positive, marked or > limit)
        int[] vals = new int[n];
        boolean[] usable = new boolean[n];
        for (int i = 0; i < n; i++) {
            vals[i] = arr[i];
            if (vals[i] <= 0 || vals[i] == Integer.MAX_VALUE || vals[i] > limit) {
                usable[i] = false;
            } else {
                usable[i] = true;
            }
        }

        BitSet[] dp = new BitSet[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new BitSet(limit + 1);
        dp[0].set(0);

        int[][] parent = new int[n + 1][limit + 1];
        int[][] prevSum = new int[n + 1][limit + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(parent[i], -1);
        }

        for (int idx = 0; idx < n; idx++) {
            if (!usable[idx]) continue;
            int val = vals[idx];
            int maxCountSoFar = Math.min(idx, n - 1);
            for (int c = maxCountSoFar; c >= 0; c--) {
                BitSet b = dp[c];
                int s = b.nextSetBit(0);
                while (s >= 0) {
                    int ns = s + val;
                    if (ns <= limit && !dp[c + 1].get(ns)) {
                        dp[c + 1].set(ns);
                        parent[c + 1][ns] = idx;
                        prevSum[c + 1][ns] = s;
                    }
                    s = b.nextSetBit(s + 1);
                }
            }
        }

        // Find best count and best sum (largest sum within limit)
        int bestCount = 0;
        int bestSum = 0;
        outer:
        for (int c = n; c >= 0; c--) {
            // scan downwards for max sum
            for (int s = limit; s >= 0; s--) {
                if (dp[c].get(s)) {
                    bestCount = c;
                    bestSum = s;
                    break outer;
                }
            }
        }

        // reconstruct indices
        List<Integer> chosenIndices = new ArrayList<>();
        int curSum = bestSum;
        int curCount = bestCount;
        while (curCount > 0) {
            int idxUsed = parent[curCount][curSum];
            if (idxUsed == -1) break;
            chosenIndices.add(idxUsed);
            curSum = prevSum[curCount][curSum];
            curCount--;
        }
        Collections.sort(chosenIndices);
        return chosenIndices;
    }

    // ---------------- Fallback Long-safe implementation ----------------
    // Uses HashMap<Long, PrevLong>[] so sums can be > Integer.MAX_VALUE.
    private static List<Integer> findBestWithLongLimit(int[] arr, long limit) {
        int n = arr.length;
        HashMap<Long, PrevLong>[] dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new HashMap<>();
        dp[0].put(0L, new PrevLong(-1L, -1));

        for (int idx = 0; idx < n; idx++) {
            long val = (long) arr[idx];
            if (val <= 0 || val == Integer.MAX_VALUE || val > limit) continue;
            for (int count = n - 1; count >= 0; count--) {
                if (dp[count].isEmpty()) continue;
                // snapshot keys
                List<Long> sums = new ArrayList<>(dp[count].keySet());
                for (long s : sums) {
                    long ns = s + val;
                    if (ns > limit) continue;
                    if (!dp[count + 1].containsKey(ns)) {
                        dp[count + 1].put(ns, new PrevLong(s, idx));
                    }
                }
            }
        }

        int bestCount = 0;
        long bestSum = 0;
        for (int c = n; c >= 0; c--) {
            if (!dp[c].isEmpty()) {
                // pick maximum long key
                long localMax = Long.MIN_VALUE;
                for (long s : dp[c].keySet()) {
                    if (s > localMax) localMax = s;
                }
                bestCount = c;
                bestSum = localMax;
                break;
            }
        }

        List<Integer> chosenIndices = new ArrayList<>();
        long curSum = bestSum;
        int curCount = bestCount;
        while (curCount > 0) {
            PrevLong p = dp[curCount].get(curSum);
            if (p == null) break;
            chosenIndices.add(p.index);
            curSum = p.prevSum;
            curCount--;
        }
        Collections.sort(chosenIndices);
        return chosenIndices;
    }

}
