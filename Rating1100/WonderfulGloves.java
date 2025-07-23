package Rating1100;

import java.util.Scanner;
import java.util.Arrays;
public class WonderfulGloves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int left[] = new int[n];
            int right[] = new int[n];
           
            for (int i = 0; i < n; i++) {
                left[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                right[i] = sc.nextInt();
            }
            long singlePair = 0;
            for (int i = 0; i <n; i++) {
                if( left[i] > right[i] ){
                    singlePair += left[i];
                    left[i] = 0;
                }else{
                    singlePair += right[i];
                    right[i] = 0;
                }
            }

            Arrays.sort(left);
            Arrays.sort(right);
            // Reverse both arrays to get descending order
            for (int i = 0; i < n / 2; i++) {
                int temp = left[i];
                left[i] = left[n - 1 - i];
                left[n - 1 - i] = temp;

                temp = right[i];
                right[i] = right[n - 1 - i];
                right[n - 1 - i] = temp;
            }
            int i=0, j=0;
            while(i<n && j<n && k>1){
                if( left[i] > right[i] ){
                    singlePair += left[i];
                    i++;
                }else{
                    singlePair += right[j];
                    j++;
                }
                k--;
            }
            System.out.println(singlePair+1);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 3 3
// 1 1 1
// 1 1 1
// 1 1
// 100
// 1
// 3 2
// 100 1 1
// 200 1 1
// 5 2
// 97 59 50 87 36
// 95 77 33 13 74
// 10 6
// 97 59 50 87 36 95 77 33 13 74
// 91 14 84 33 54 89 68 34 14 15
// OutputCopy
// 6
// 101
// 303
// 481
// 1010