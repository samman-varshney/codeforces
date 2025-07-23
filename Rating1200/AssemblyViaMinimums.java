package Rating1200;

import java.util.*;

public class AssemblyViaMinimums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            
            int[] arr = new int[(n*(n-1))/2];
            for(int i=0; i<arr.length; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int[] res = new int[n];
            int i=0, count = n-1;
            while( i < arr.length && count > 0) {
                res[count] = arr[i];
                i += count;
                count--;
            }
            res[0] = res[1];
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// Example
// InputCopy
// 5
// 3
// 1 3 1
// 2
// 10
// 4
// 7 5 3 5 3 3
// 5
// 2 2 2 2 2 2 2 2 2 2
// 5
// 3 0 0 -2 0 -2 0 0 -2 -2
// OutputCopy
// 1 3 3
// 10 10
// 7 5 3 12
// 2 2 2 2 2
// 0 -2 0 3 5