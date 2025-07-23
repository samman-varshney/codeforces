package Rating1100;

import java.util.Scanner;
public class GCDPartition {
    static long gcd(long a, long b) {
    while (b != 0) {
        long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            long[] prefixSum = new long[n];
            int[] arr = new int[n];
            long prefix = 0;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                prefixSum[i] = arr[i]+prefix;
                prefix = prefixSum[i];
            }
            long res = 0;
            for(int i=0; i<n-1; i++){
                long a = prefixSum[i];
                long b = prefixSum[n-1] - a;
                res = Math.max(res, gcd(a, b));
            }
            System.out.println(res);

        }
        sc.close();
    }
}


// Example
// InputCopy
// 6
// 4
// 2 2 1 3
// 2
// 1 2
// 3
// 1 4 5
// 6
// 1 2 1 1 1 3
// 10
// 12 30 37 88 12 78 89 17 2 12
// 6
// 7 7 7 7 7 7
// OutputCopy
// 4
// 1
// 5
// 3
// 1
// 21