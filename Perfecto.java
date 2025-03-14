import java.util.*;

public class Perfecto {

    // Function to check if a number is a perfect square
    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    // Backtracking with memoization and early pruning
    private static boolean helper(ArrayList<Integer> res, int sum, int n, boolean[] used, Map<String, Boolean> memo) {
        if (res.size() == n)
            return true; // Base case: all numbers used

        String key = Arrays.toString(used); // Memoization key
        if (memo.containsKey(key))
            return memo.get(key);

        for (int i = n; i >= 1; i--) { // Try placing larger numbers first
            if (!used[i] && !isPerfectSquare(sum + i)) {
                used[i] = true; // Mark as used
                res.add(i);

                if (helper(res, sum + i, n, used, memo)) {
                    memo.put(key, true);
                    return true;
                }

                // Backtrack
                res.remove(res.size() - 1);
                used[i] = false;
            }
        }
        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            int n = sc.nextInt();
            boolean[] used = new boolean[n + 1]; // Track used numbers
            ArrayList<Integer> res = new ArrayList<>();
            Map<String, Boolean> memo = new HashMap<>(); // Memoization map

            if (helper(res, 0, n, used, memo)) {
                for (int num : res)
                    System.out.print(num + " ");
            } else {
                System.out.print(-1);
            }
            System.out.println();
        }
        sc.close();
    }
}
