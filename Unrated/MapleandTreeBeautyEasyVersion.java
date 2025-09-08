package Unrated;

import java.util.*;

public class MapleandTreeBeautyEasyVersion {
    static HashMap<Integer, Integer> map;
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
            int[] arr = new int[minHeight];
            for(int i=0; i<minHeight; i++){
                arr[i] = map.getOrDefault(i+1, 0);
            }
            // first choose up to min(k, n-k), then remaining with other capacity
            List<Integer> res = findBestSubsequenceIndices(arr, Math.min(k, n-k));
            ans += res.size();
            for(int i: res){
                arr[i] = Integer.MAX_VALUE; // mark as used (large so won't be picked again)
            }
            res = findBestSubsequenceIndices(arr, Math.max(k, n-k));
            ans += res.size();
            System.out.println(ans);
        }
        sc.close();
    }

    private static void helper(ArrayList<ArrayList<Integer>> adj, int node, int height) {
        map.put(height, map.getOrDefault(height, 0) + 1);
        if (adj.get(node).size() == 0) {
            minHeight = Math.min(height, minHeight);
        }
        for (int child : adj.get(node)) {
            helper(adj, child, height + 1);
        }
    }

    // ---------- Optimized DP implementation ----------
    /**
     * Returns a list of indices (0-based, in original order) representing a
     * subsequence with:
     * - maximum length such that sum <= limit
     * - among those with max length, maximum possible sum
     *
     * Uses BitSet + primitive parent arrays for speed.
     */
    public static List<Integer> findBestSubsequenceIndices(int[] arr, int limit) {
        int n = arr.length;
        // quick guards
        if (n == 0 || limit <= 0) return new ArrayList<>();

        // If a value is marked Integer.MAX_VALUE (used), treat as unpickable: skip
        // Also compress values larger than limit to skip early
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

        // dp[c] : BitSet of achievable sums using exactly c items (sums 0..limit)
        BitSet[] dp = new BitSet[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new BitSet(limit + 1);
        dp[0].set(0);

        // parent[c][s] = index of item used to reach sum s with c items (or -1)
        // prevSum[c][s] = previous sum before adding that item
        int[][] parent = new int[n + 1][limit + 1];
        int[][] prevSum = new int[n + 1][limit + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(parent[i], -1);
        }

        // Process items
        for (int idx = 0; idx < n; idx++) {
            if (!usable[idx]) continue; // skip unusable items (too large / marked)
            int val = vals[idx];
            // counts possible so far is at most idx (we can't pick more items than processed)
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

        // Find largest count with any achievable sum; among sums pick maximum
        int bestCount = 0;
        int bestSum = 0;
        for (int c = n; c >= 0; c--) {
            // check if dp[c] has any bit set
            int candidate = dp[c].previousSetBit(limit); // if Java version supports previousSetBit
            if (candidate >= 0) {
                bestCount = c;
                bestSum = candidate;
                break;
            } else {
                // fallback if previousSetBit is not available (older JVMs)
                int tmp = dp[c].length(); // length is lastSetBit+1
                if (tmp > 0) {
                    int maxS = Math.min(limit, tmp - 1);
                    // find downward
                    int s = dp[c].previousSetBit(maxS);
                    if (s >= 0) {
                        bestCount = c;
                        bestSum = s;
                        break;
                    }
                }
            }
        }

        // If previousSetBit not available on some Java versions, use manual scan
        if (bestCount == 0 && bestSum == 0) {
            // check c from n..0 and s from limit..0
            outer:
            for (int c = n; c >= 0; c--) {
                for (int s = limit; s >= 0; s--) {
                    if (dp[c].get(s)) {
                        bestCount = c;
                        bestSum = s;
                        break outer;
                    }
                }
            }
        }

        // reconstruct indices
        List<Integer> chosenIndices = new ArrayList<>();
        int curSum = bestSum;
        int curCount = bestCount;
        while (curCount > 0) {
            int idxUsed = parent[curCount][curSum];
            if (idxUsed == -1) break; // defensive
            chosenIndices.add(idxUsed);
            curSum = prevSum[curCount][curSum];
            curCount--;
        }
        Collections.sort(chosenIndices); // ensure original order (indices are 0-based)
        return chosenIndices;
    }

}

// Examples
// InputCopy
// 5
// 7 3
// 1 1 2 2 3 3
// 7 2
// 1 1 2 3 1 1
// 5 0
// 1 2 3 4
// 5 2
// 1 1 1 1
// 5 4
// 1 1 1 1
// OutputCopy
// 3
// 2
// 5
// 1
// 2
// InputCopy
// 5
// 2 0
// 1
// 2 1
// 1
// 3 0
// 1 1
// 3 1
// 1 2
// 3 1
// 1 1
// OutputCopy
// 2
// 2
// 2
// 3
// 2