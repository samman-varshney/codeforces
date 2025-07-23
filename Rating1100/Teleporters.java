package Rating1100;

import java.util.Scanner;
import java.util.Arrays;
public class Teleporters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int coins = sc.nextInt();

            int[] arr = new int[n];
            for(int i=0; i<n; i++){
              
                arr[i] = sc.nextInt()+i+1;
            }
            Arrays.sort(arr);
            int res = 0;
            int i=0;
            while(i<n && coins >= arr[i]){
                res++;
                coins -= arr[i];
                i++;
            }
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 10
// 5 6
// 1 1 1 1 1
// 8 32
// 100 52 13 6 9 4 100 35
// 1 1
// 5
// 4 5
// 4 3 2 1
// 5 9
// 2 3 1 4 1
// 5 8
// 2 3 1 4 1
// 4 3
// 2 3 4 1
// 4 9
// 5 4 3 3
// 2 14
// 7 5
// 5 600000000
// 500000000 400000000 300000000 200000000 100000000
// OutputCopy
// 2
// 2
// 0
// 1
// 2
// 2
// 1
// 1
// 1
// 2
