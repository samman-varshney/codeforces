import java.util.*;

public class C2162{

    //-------------------------Boiler Code----------------------//

    //segement tree
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

    //get max of an array (int)
    public static int getMaxOfArray(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        return max;
    }
    //get max of an array (long)
    public static long getMaxOfArray(long[] nums){
        long max = Long.MIN_VALUE;
        for(long num : nums)
            max = Math.max(max, num);
        return max;
    }
    //get min of an array (int)
    public static int getMinOfArray(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int num : nums)
            min = Math.min(min, num);
        return min;
    }
    //get min of an array (long)
    public static long getMinOfArray(long[] nums){
        long min = Long.MAX_VALUE;
        for(long num : nums)
            min = Math.min(min, num);
        return min;
    }
    //lower bound of an array
    public static int lowerBound(int[] nums, int val){
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= val){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }
    //upper bound of an array
    public static int upperBound(int[] nums, int val){
        int start = 0, end = nums.length;
        while(start <= end){
            int mid = start+ (end -start)/2;
            if(nums[mid] >= val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    //gcd of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    //lcm of two numbers
    public static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }
    static boolean isSet(int n, int pos) {
        return (n & (1 << pos)) != 0;
    }

    // Set a bit
    static int setBit(int n, int pos) {
        return n | (1 << pos);
    }

    // Unset a bit
    static int unsetBit(int n, int pos) {
        return n & ~(1 << pos);
    }
    static int getMSBPosition(int n) {
        if (n == 0) return -1;
        int pos = 0;
        while (n > 1) {
            n >>= 1;
            pos++;
        }
        return pos;
    }

    //-----------------------------------------------------//

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            helper(a, b);
        }
        sc.close();
    }
    public static void helper(int a, int b){
        if(getMSBPosition(a) < getMSBPosition(b)){
            System.out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>();
        int num = 0;
        int n = getMSBPosition(a);
        // System.out.println(n);
        for(int i=0; i<=n; i++){
            boolean bitA = isSet(a, i);
            boolean bitB = isSet(b, i);
            
            if(bitA != bitB){
                int temp = setBit(num, i);
                if(temp > a){
                    list.add(num);
                    a ^= num;
                    i--;
                    num = 0;
                }else{
                    num = temp;
                }
            }
        }
        if(num!=0)list.add(num);
        System.out.println(list.size());
        for(int x: list)
            System.out.print(x+" ");
        if(list.size()!=0)System.out.println();
    }
}

// Example
// InputCopy
// 6
// 9 6
// 13 13
// 292 929
// 405 400
// 998 244
// 244 353
// OutputCopy
// 2
// 7 8
// 0
// -1
// 1
// 5
// 2
// 25 779
// -1
