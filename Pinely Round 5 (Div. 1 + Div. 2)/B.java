import java.util.*;
import java.io.*;

public class B {

    // -------------------------Boiler Code----------------------//
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // segment tree
    public class SegementTree {
        int[][] tree;
        int[] lazy;

        public SegementTree(int n) {
            tree = new int[4 * n][2];
            lazy = new int[4 * n];
        }

        public void build(int arr[], int v, int l, int r) {
            if (l == r) {
                tree[v][0] = arr[l];
                tree[v][1] = arr[l] * arr[l];
            } else {
                int mid = (l + r) / 2;
                build(arr, v * 2 + 1, l, mid);
                build(arr, v * 2 + 2, mid + 1, r);
                tree[v][0] = tree[v * 2 + 1][0] + tree[v * 2 + 2][0];
                tree[v][1] = tree[v * 2 + 1][1] + tree[v * 2 + 2][1];
            }
        }

        public void removeLaziness(int v, int l, int r) {
            if (lazy[v] != 0) {
                int len = (r - l + 1);
                tree[v][1] += 2 * lazy[v] * tree[v][0] + len * lazy[v] * lazy[v];
                tree[v][0] += lazy[v] * len;

                if (l != r) {
                    lazy[v * 2 + 1] += lazy[v];
                    lazy[v * 2 + 2] += lazy[v];
                }
                lazy[v] = 0;
            }
        }

        public int query(int v, int l, int r, int ql, int qr) {
            removeLaziness(v, l, r);
            if (ql <= l && qr >= r) {
                return tree[v][1];
            } else if (ql > r || qr < l) {
                return 0;
            } else {
                int mid = (l + r) / 2;
                int left = query(v * 2 + 1, l, mid, ql, qr);
                int right = query(v * 2 + 2, mid + 1, r, ql, qr);
                return left + right;
            }
        }

        public void updateRange(int v, int l, int r, int ql, int qr, int value) {
            removeLaziness(v, l, r);
            if (ql > r || qr < l) {
                return;
            }
            if (ql <= l && qr >= r) {
                lazy[v] += value;
                removeLaziness(v, l, r);
                return;
            }
            int mid = (l + r) / 2;
            updateRange(v * 2 + 1, l, mid, ql, qr, value);
            updateRange(v * 2 + 2, mid + 1, r, ql, qr, value);
            tree[v][0] = tree[v * 2 + 1][0] + tree[v * 2 + 2][0];
            tree[v][1] = tree[v * 2 + 1][1] + tree[v * 2 + 2][1];
        }
    }

    // get max of an array (int)
    public static int getMaxOfArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // get max of an array (long)
    public static long getMaxOfArray(long[] nums) {
        long max = Long.MIN_VALUE;
        for (long num : nums)
            max = Math.max(max, num);
        return max;
    }

    // get min of an array (int)
    public static int getMinOfArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums)
            min = Math.min(min, num);
        return min;
    }

    // get min of an array (long)
    public static long getMinOfArray(long[] nums) {
        long min = Long.MAX_VALUE;
        for (long num : nums)
            min = Math.min(min, num);
        return min;
    }

    // lower bound of an array
    public static int lowerBound(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    // upper bound of an array
    public static int upperBound(int[] nums, int val) {
        int start = 0, end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // gcd of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // lcm of two numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // -----------------read methods-------------------------//
    public static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long readLong() throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static float readFloat() throws IOException {
        return Float.parseFloat(br.readLine().trim());
    }

    public static double readDouble() throws IOException {
        return Double.parseDouble(br.readLine().trim());
    }

    public static String readString() throws IOException {
        return br.readLine().trim();
    }

    public static long[] readLongArray(int n) throws IOException {
        long[] arr = new long[n];
        String[] tokens = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(tokens[i]);
        return arr;
    }

    public static double[] readDoubleArray(int n) throws IOException {
        double[] arr = new double[n];
        String[] tokens = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Double.parseDouble(tokens[i]);
        return arr;
    }

    public static float[] readFloatArray(int n) throws IOException {
        float[] arr = new float[n];
        String[] tokens = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Float.parseFloat(tokens[i]);
        return arr;
    }

    public static int[] readIntArray(int n) throws IOException {
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        return arr;
    }

    // --------------------print methods-----------------------//
    public static void printArray(int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + (i < arr.length - 1 ? " " : ""));
        }
        bw.newLine();
        bw.flush();
    }

    public static void printArray(char[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                bw.write(' ');
            bw.write(arr[i]);
        }
        bw.newLine();
        bw.flush();
    }

    public static void printArray(long[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                bw.write(' ');
            bw.write(Long.toString(arr[i]));
        }
        bw.newLine();
        bw.flush();
    }

    public static void printArray(float[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                bw.write(' ');
            bw.write(Float.toString(arr[i]));
        }
        bw.newLine();
        bw.flush();
    }

    public static void printArray(double[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                bw.write(' ');
            bw.write(Double.toString(arr[i]));
        }
        bw.newLine();
        bw.flush();
    }

    public static <T> void printArray(T[] arr) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1)
                sb.append(" ");
        }
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
    }

    public static void println(int x) throws IOException {
        bw.write(Integer.toString(x));
        bw.newLine();
        bw.flush();
    }

    public static void println(long x) throws IOException {
        bw.write(Long.toString(x));
        bw.newLine();
        bw.flush();
    }

    public static void println(float x) throws IOException {
        bw.write(Float.toString(x));
        bw.newLine();
        bw.flush();
    }

    public static void println(double x) throws IOException {
        bw.write(Double.toString(x));
        bw.newLine();
        bw.flush();
    }

    public static void println(char x) throws IOException {
        bw.write(x);
        bw.newLine();
        bw.flush();
    }

    public static void println(boolean x) throws IOException {
        bw.write(Boolean.toString(x));
        bw.newLine();
        bw.flush();
    }

    public static void println() throws IOException {
        bw.newLine();
        bw.flush();
    }

    public static <T> void println(T obj) throws IOException {
        bw.write(obj.toString());
        bw.newLine();
        bw.flush();
    }

    public static void print(int x) throws IOException {
        bw.write(Integer.toString(x));
        bw.flush();
    }

    public static void print(long x) throws IOException {
        bw.write(Long.toString(x));
        bw.flush();
    }

    public static void print(float x) throws IOException {
        bw.write(Float.toString(x));
        bw.flush();
    }

    public static void print(double x) throws IOException {
        bw.write(Double.toString(x));
        bw.flush();
    }

    public static void print(char x) throws IOException {
        bw.write(x);
        bw.flush();
    }

    public static void print(boolean x) throws IOException {
        bw.write(Boolean.toString(x));
        bw.flush();
    }

    public static <T> void print(T obj) throws IOException {
        bw.write(obj.toString());
        bw.flush();
    }

    // -----------------------------------------------------//

    public static void main(String[] args) {
        try {
            int tcase = readInt();
            while (tcase-- > 0) {
                int n = readInt();
                char[][] arr = new char[n][n];
                for (int i = 0; i < n; i++) {
                    arr[i] = readString().toCharArray();
                }
                helper(n, arr);
            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static void helper(int n, char[][] arr) throws IOException {
        boolean isBlack = false;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n && arr[i][j] != '#') {
                j++;
            }
            int count = 0;
            while (j < n && arr[i][j] == '#') {
                isBlack = true;
                j++;
                count++;
                if (count >= 3) {
                    println("NO");
                    return;
                }
            }

            while (j < n) {
                if (arr[i][j] == '#') {
                    println("NO");
                    return;
                }
                j++;
            }
        }

        if (!isBlack) {
            println("YES");
            return;
        }

        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < n && arr[i][j] != '#') {
                i++;
            }
            int count = 0;
            while (i < n && arr[i][j] == '#') {
                i++;
                count++;
                if (count >= 3) {
                    println("NO");
                    return;
                }
            }

            while (i < n) {
                if (arr[i][j] == '#') {
                    println("NO");
                    return;
                }
                i++;
            }
        }
        int[][] grid = convertToBinaryMatrix(arr);

        int count = countComponents(grid);
        boolean res = has2x2Block(grid);

        if (res) {
            println(count == 1 ? "YES" : "NO");
            return;
        }

        if (canCoverAllOnes(grid)) {
            println("YES");
            return;
        }
        println("NO");

    }

    public static boolean has2x2Block(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (grid[i][j] == 1 && grid[i][j + 1] == 1 &&
                        grid[i + 1][j] == 1 && grid[i + 1][j + 1] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countComponents(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == 0)
            return;
        visited[i][j] = true;

        dfs(grid, visited, i + 1, j, n, m);
        dfs(grid, visited, i - 1, j, n, m);
        dfs(grid, visited, i, j + 1, n, m);
        dfs(grid, visited, i, j - 1, n, m);
    }

    public static int[][] convertToBinaryMatrix(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] binary = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '.') {
                    binary[i][j] = 0;
                } else if (matrix[i][j] == '#') {
                    binary[i][j] = 1;
                } else {
                    throw new IllegalArgumentException("Invalid character: " + matrix[i][j]);
                }
            }
        }

        return binary;
    }

       private static final int[] LEFT  = {0, -1};
    private static final int[] RIGHT = {0,  1};
    private static final int[] DOWN  = {1,  0};

    // pattern names and vectors
    private static final String[] PAT_NAMES = {"L-D", "D-L", "R-D", "D-R"};
    private static final int[][][] PATTERNS = {
        { LEFT,  DOWN }, // left then down
        { DOWN,  LEFT }, // down then left
        { RIGHT, DOWN }, // right then down
        { DOWN,  RIGHT } // down then right
    };

    public static boolean canCoverAllOnes(int[][] grid) {
        int n = grid.length;
        if (n == 0) return true;
        int m = grid[0].length;

        // count total ones
        int totalOnes = 0;
        for (int[] row : grid) for (int v : row) if (v == 1) totalOnes++;

        if (totalOnes == 0) return true;

        // find topmost 1 (first by row, then by column)
        int sr = -1, sc = -1;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) { sr = i; sc = j; break outer; }
            }
        }
        if (sr == -1) return true;

        // try each pattern
        for (int p = 0; p < PATTERNS.length; p++) {
            boolean[][] visited = new boolean[n][m];
            int coveredCount = simulatePattern(grid, visited, sr, sc, PATTERNS[p][0], PATTERNS[p][1]);
            if (coveredCount == totalOnes) {
                // System.out.println("SUCCESS pattern: " + PAT_NAMES[p]);
                // printVisited(visited);
                return true;
            }
        }
        return false;
    }

    // simulate zig-zag; stop only when next move would be out-of-bounds
    private static int simulatePattern(int[][] grid, boolean[][] visited, int r, int c, int[] d1, int[] d2) {
        int n = grid.length, m = grid[0].length;
        int covered = 0;

        if (grid[r][c] == 1) { visited[r][c] = true; covered++; }

        boolean useFirst = true;
        while (true) {
            int[] d = useFirst ? d1 : d2;
            int nr = r + d[0], nc = c + d[1];

            // STOP only if next move is out-of-bounds
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) break;

            // make the move
            r = nr; c = nc;
            if (grid[r][c] == 1 && !visited[r][c]) {
                visited[r][c] = true;
                covered++;
            }

            // alternate
            useFirst = !useFirst;
        }
        return covered;
    }
}

// Example
// InputCopy
// 11
// 1
// .
// 1
// #
// 3
// .##
// .##
// ...
// 3
// #..
// .#.
// ..#
// 3
// ###
// ...
// ...
// 3
// #.#
// ...
// .#.
// 4
// ####
// #..#
// #..#
// ####
// 3
// ..#
// ...
// .#.
// 3
// ..#
// #..
// ...
// 5
// #.#.#
// .#.#.
// #.#.#
// .#.#.
// #.#.#
// 5
// ...#.
// ...#.
// .....
// ##...
// .....
// OutputCopy
// YES
// YES
// YES
// YES
// NO
// NO
// NO
// YES
// YES
// NO
// YES