package HLD;

import java.util.*;
import java.io.*;

public class E609 {

    // -------------------------Boiler Code----------------------//
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // -------------------------DSU--------------------------------
    static int[] parent, size;

    static int find(int u) {
        if (u == parent[u])
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

    static void initialDS(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }

    public static <T extends Comparable<T>> T min(T a, T b) {
        return (a.compareTo(b) < 0) ? a : b;
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
        int start = 0, end = nums.length - 1;
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
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // lcm of two numbers
    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // reverSse in a range
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // swap to numbers
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // -----------------read methods-------------------------//
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static long nextLong() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }

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

    public static String[] readStringArray(int n) throws IOException {
        return br.readLine().split(" ");
    }

    public static long[] readLongArray(int n) throws IOException {
        long[] arr = new long[n];
        String[] tokens = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(tokens[i]);
        return arr;
    }

    public static List<Integer> intList() throws IOException {
        List<Integer> a = new ArrayList<>();
        String[] tokens = br.readLine().trim().split(" ");
        for (String s : tokens)
            a.add(Integer.parseInt(s));
        return a;
    }

    public static List<Long> longList() throws IOException {
        List<Long> a = new ArrayList<>();
        String[] tokens = br.readLine().trim().split(" ");
        for (String s : tokens)
            a.add(Long.parseLong(s));
        return a;
    }

    public static List<String> stringList() throws IOException {
        List<String> a = new ArrayList<>();
        String[] tokens = br.readLine().trim().split(" ");
        for (String s : tokens)
            a.add(s);
        return a;
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

    public static int[][] read2DArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(parts[j]);
            }
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

    public static <T extends Number> int getMSBPosition(T num) {
        long n = num.longValue();
        if (n == 0)
            return -1; // No set bit

        int pos = 0;
        while (n > 0) {
            n >>= 1;
            pos++;
        }
        return pos - 1; // Zero-based index
    }

    public static <T> void printList(List<T> list) throws IOException {
        for (T element : list) {
            bw.write(element + " ");
        }
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
    static int n, m;
    static List<Quad> edges;

    public static void main(String[] args) {
        try {
            int tcase = 1;
            while (tcase-- > 0) {
                n = nextInt();
                m = nextInt();

                edges = new ArrayList<>();

                for (int i = 0; i < m; i++) {
                    int u = nextInt();
                    int v = nextInt();
                    int wt = nextInt();
                    int idx = i;

                    edges.add(new Quad(u, v, wt, idx));
                }
                helper();
            }
        } catch (Exception err) {
            System.err.println("An unexpected error occurred:");
            err.printStackTrace();
        }
    }

    static List<List<Tuple>> adj;
    static int[] used;
    static int[] depth, map, values, heavy;

    static void dfs(int u) {
        for (Tuple t : adj.get(u)) {
            int v = t.v;
            int wt = t.wt;
            if (v != parent[u]) {
                depth[v] = depth[u] + 1;
                parent[v] = u;
                values[v] = wt;

                dfs(v);

                size[u] += size[v];
                if (size[heavy[u]] < size[v]) {
                    heavy[u] = v;
                }
            }
        }
        size[u]++;
    }

    static int[] head, pos, lt;
    static int time;

    static void dfsHLD(int u, int chain) {
        head[u] = chain;
        lt[time] = values[u];
        pos[u] = time;
        time++;

        if (heavy[u] != 0) {
            dfsHLD(heavy[u], chain);
        }

        for (Tuple t : adj.get(u)) {
            if (t.v != parent[u] && t.v != heavy[u]) {
                dfsHLD(t.v, t.v);
            }
        }
    }

    static int[] t;

    static void build(int v, int l, int r) {
        if (l == r) {
            t[v] = lt[l];
        } else {
            int mid = (l + r) / 2;
            build(2 * v, l, mid);
            build(2 * v + 1, mid + 1, r);

            t[v] = Math.max(t[2 * v], t[2 * v + 1]);
        }
    }

    static int query(int v, int tl, int tr, int l, int r) {
        if (tl >= l && tr <= r) {
            return t[v];
        } else if (tl > r || tr < l) {
            return 0;
        } else {
            int mid = (tl + tr) / 2;
            return max(query(2 * v, tl, mid, l, r), query(2 * v + 1, mid + 1, tr, l, r));
        }
    }

    static int getMaxEdge(int a, int b) {
        int maxEdge = Integer.MIN_VALUE;
        while (head[a] != head[b]) {
            if (depth[head[a]] < depth[head[b]]) {
                int t = a;
                a = b;
                b = t;
            }

            maxEdge = max(maxEdge, query(1, 0, n, pos[head[a]], pos[a]));
            a = parent[head[a]];
        }

        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        maxEdge = max(maxEdge, query(1, 0, n, pos[b] + 1, pos[a]));
        return maxEdge;
    }

    public static void helper() throws IOException {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Collections.sort(edges, (a, b) -> (a.wt - b.wt));
        adj = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        used = new int[m];
        for (Quad q : edges) {
            if (find(q.u) != find(q.v)) {
                union(q.u, q.v);
                adj.get(q.u).add(new Tuple(q.v, q.wt));
                adj.get(q.v).add(new Tuple(q.u, q.wt));
                sum += q.wt;
                used[q.idx] = 1;
            }
        }

        parent = new int[n + 1];
        size = new int[n + 1];
        depth = new int[n + 1];
        map = new int[n + 1];
        values = new int[n + 1];
        heavy = new int[n + 1];

        dfs(1);

        head = new int[n + 1];
        pos = new int[n + 1];
        lt = new int[n + 1];
        time = 0;

        dfsHLD(1, 1);

        t = new int[4 * (n + 1)];
        build(1, 0, n);
        Collections.sort(edges, (a, b) -> (a.idx - b.idx));
        for (int i = 0; i < m; i++) {
            int u = edges.get(i).u;
            int v = edges.get(i).v;
            int idx = edges.get(i).idx;
            int wt = edges.get(i).wt;
            if (used[idx] == 1) {
                println(sum);
            } else {
                println(sum + wt - getMaxEdge(u, v));
            }
        }
    }
}

class Quad {
    int u, v, wt, idx;

    Quad(int u, int v, int wt, int idx) {
        this.u = u;
        this.v = v;
        this.idx = idx;
        this.wt = wt;
    }
}

class Tuple {
    int v, wt;

    Tuple(int v, int wt) {
        this.wt = wt;
        this.v = v;
    }
}
