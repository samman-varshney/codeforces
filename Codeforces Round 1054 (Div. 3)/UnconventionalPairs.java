
import java.util.*;

public class UnconventionalPairs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextLong();
            }

            Arrays.sort(arr);
            long diff = Long.MIN_VALUE;
            for(int i=n-2; i>=0; i-=2){
                diff = Math.max(diff, arr[i+1] - arr[i]);
            }
            System.out.println(diff);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 2
// 1 2
// 4
// 10 1 2 9
// 6
// 3 8 9 3 3 2
// 8
// 5 5 5 5 5 5 5 5
// 4
// -5 -1 2 6
// OutputCopy
// 1
// 1
// 1
// 0
// 4