import java.util.*;
import java.io.*;

public class D2158 {

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

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
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

    public static void main(String[] args) {
        try {
            int tcase = readInt();
            while (tcase-- > 0) {
                int n = readInt();
                char[] s = readString().toCharArray();
                char[] t = readString().toCharArray();

                helper(n, s, t);
            }
        } catch (Exception err) {
            System.err.println("An unexpected error occurred:");
            err.printStackTrace();
        }
    }

    private static boolean isAlternating(char[] s, char[] t) {
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (Math.abs(s[i] - t[i]) != 1)
                return false;
        }
        return true;
    }

    private static int findCouple(char[] s) {
        int n = s.length;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1])
                return i;
        }
        return -1;
    }

    private static void flip(int l, int r, char[] s){
        for(int i=l; i<=r; i++){
            s[i] = s[i]=='0'?'1':'0';
        }
    }

    private static boolean allZeros(char[] s){
        for(char c: s){
            if(c != '0')
                return false;
        }
        return true;
    }

    private static List<String> convertToZero(char[] s, int idx){
        int n = s.length;
        int i = idx, j =idx;
        List<String> list = new ArrayList<>();
        while ( i>0 || j<n-1){

            while(i-1 >= 0 && s[i] == s[i-1]){
                i--;
            }
            while(j+1 < n && s[j] == s[j+1]){
                j++;
            }

            list.add((i+1)+" "+(j+1));
            flip(i, j, s);
        }

        if(allZeros(s)){
            return list;
        }

        list.add(1+" "+n);
        return list;
    }

    public static void helper(int n, char[] s, char[] t) throws Exception {
        if (isAlternating(s, t)) {
            println(1);
            println(1 + " " + n);
            return;
        }

        int idx1 = findCouple(s);
        int idx2 = findCouple(t);

        if(idx1 == -1 || idx2 == -1){
            println(-1);
            return;
        }

        List<String> l1 = convertToZero(s, idx1);
        List<String> l2 = convertToZero(t, idx2);
       

        println(l1.size()+l2.size());

        for(String range: l1)
            println(range);
        for(int i=l2.size()-1; i>=0; i--)
            println(l2.get(i));
    }

}

// Example
// InputCopy
// 3
// 5
// 01011
// 10000
// 7
// 1010101
// 0101010
// 4
// 0010
// 0010
// OutputCopy
// 2
// 1 3
// 3 5
// 1
// 1 7
// 0