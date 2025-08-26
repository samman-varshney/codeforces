package Unrated;

import java.util.Scanner;
public class LeftmostBelow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            long range = 2 * arr[0] - 1;
            boolean isValid = true;
            for(int i=1; i<n; i++){
                if(arr[i] > range){
                    isValid = false;
                    break;
                }
                range = Math.min(range, 2 * arr[i] - 1);
            }
            System.out.println(isValid ? "YES" : "NO");
        }
        sc.close();
    }
}
// Example
// InputCopy
// 4
// 4
// 5 6 1 1
// 3
// 3 1 2
// 3
// 40 60 90
// 2
// 1 1
// OutputCopy
// YES
// NO
// NO
// YES