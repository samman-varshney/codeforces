package Unrated;

import java.util.Scanner;
import java.util.Arrays;
public class RecyclingCenter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            long c = sc.nextLong();

            long[] arr = new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLong();
            }
            Arrays.sort(arr);
            long cf = 1;
            int count = 0;
            for(int i=n-1; i>=0; i--){
                if(arr[i]*cf <= c){
                    cf *= 2;
                    count++;
                }
            }
            System.out.println(n - count);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 4
// 5 10
// 10 4 15 1 8
// 3 42
// 1000000000 1000000000 1000000000
// 10 30
// 29 25 2 12 15 42 14 6 16 9
// 10 1000000
// 1 1 1 1 1 1 1 1 1 864026633
// OutputCopy
// 2
// 3
// 6
// 1