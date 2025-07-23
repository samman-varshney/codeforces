package Rating1100;

import java.util.Scanner;
public class ANDSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int first = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                if(arr[i]!=i){
                    first &= arr[i];
                }
            }
            System.out.println(first);
            
        }
        sc.close();
    }
}
// Example
// InputCopy
// 4
// 4
// 0 1 3 2
// 2
// 1 0
// 7
// 0 1 2 3 5 6 4
// 5
// 0 3 2 1 4
// OutputCopy
// 2
// 0
// 4
// 1
