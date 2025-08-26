package Rating1200;

import java.util.Scanner;
public class DifferentialSorting {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            boolean isSorted = true;
            long prev = Long.MIN_VALUE;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                if(arr[i] < prev && isSorted) {
                    isSorted = false;
                }
                prev = arr[i];
            }
            if( isSorted ) {
                System.out.println(0);
            }else if(arr[n-2] > arr[n-1] || arr[n-1] < 0) {
                System.out.println(-1);
            }else{
                System.out.println(n-2);
                for (int i = n-3; i >=0; i-- ) {
                    System.out.println((i+1)+" "+(n-1)+" "+n);
                }
                
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 5
// 5 -4 2 -1 2
// 3
// 4 3 2
// 3
// -3 -2 -1
// OutputCopy
// 2
// 1 2 3
// 3 4 5
// -1
// 0