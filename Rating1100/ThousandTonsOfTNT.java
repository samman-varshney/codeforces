package Rating1100;


import java.util.Scanner;
public class ThousandTonsOfTNT {

    public static long helper(int group, long[] arr){
        long prev = 0;
        long maxgp = Long.MIN_VALUE, mingp = Long.MAX_VALUE;
        int i = group;
        while( i <= arr.length){
            long sum = arr[i-1] - prev;
            maxgp = Math.max(maxgp, sum);
            mingp = Math.min(mingp, sum);
            prev = arr[i-1];
            i += group;
        }
        return maxgp - mingp;
    }

    public static long getFactors(long[] arr) {
        long max = Long.MIN_VALUE;
        int n = arr.length;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                max = Math.max(max, Math.max(helper(i, arr),helper(n / i, arr)));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            long prev = 0;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt() + prev;
                prev = arr[i];
            }
            System.out.println(getFactors(arr));
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 2
// 1 2
// 6
// 10 2 3 6 1 3
// 4
// 1000000000 1000000000 1000000000 1000000000
// 15
// 60978 82265 78961 56708 39846 31071 4913 4769 29092 91348 64119 72421 98405 222 14294
// 8
// 19957 69913 37531 96991 57838 21008 14207 19198
// OutputCopy
// 1
// 9
// 0
// 189114
// 112141