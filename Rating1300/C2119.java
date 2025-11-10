import java.util.*;
import java.io.*;
@SuppressWarnings("unused" )
public class C2119 {

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
    public static int[][] read2DArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
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
        if (n == 0) return -1; // No set bit

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

    public static void main(String[] args) {
        try {
            int tcase = readInt();
            while (tcase-- > 0) {
                long[] arr = readLongArray(4);
                helper(arr[0], arr[1], arr[2], arr[3]);
            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static void helper(long n, long l, long r, long k) throws IOException {
        if((n&1) == 1){
            println(l);
            return;
        }
        int m1 = getMSBPosition(l);
        int m2 = getMSBPosition(r);
        if(n == 2 || m1 >= m2){
            println(-1);
            return;
        }
        if(k<=n-2){
            println(l);
            return;
        }
        println(1L<<(m1+1L));
        
    }
}

// Example
// InputCopy
// 9
// 1 4 4 1
// 3 1 3 3
// 4 6 9 2
// 4 6 9 3
// 4 6 7 4
// 2 5 5 1
// 2 3 6 2
// 999999999999999999 1000000000000000000 1000000000000000000 999999999999999999
// 1000000000000000000 1 999999999999999999 1000000000000000000
// OutputCopy
// 4
// 1
// 6
// 8
// -1
// -1
// -1
// 1000000000000000000
// 2