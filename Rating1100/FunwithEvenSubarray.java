package Rating1100;

import java.util.Scanner;
public class FunwithEvenSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int i = n-1, count = 0;
            int key = arr[n-1];
            while( i >= 0){
                while(i >=0 && arr[i] == key)
                    i--;
                
                if(i < 0){
                    break;
                }
                count++;
                i -= Math.min( n-i-1, i+1);
            }
            System.out.println(count);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 3
// 1 1 1
// 2
// 2 1
// 5
// 4 4 4 2 4
// 4
// 4 2 1 3
// 1
// 1
// OutputCopy
// 0
// 1
// 1
// 2
// 0