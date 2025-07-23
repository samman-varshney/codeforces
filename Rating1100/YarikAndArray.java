package Rating1100;

import java.util.Scanner;
public class YarikAndArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int maxEnding = arr[0];
            int res = arr[0];

            for(int i=1; i<n; i++){
                if( (arr[i-1]&1) != (arr[i]&1)){
                    maxEnding = Math.max(maxEnding+arr[i], arr[i]);
                }else{
                    maxEnding = arr[i];
                }
                res = Math.max(res, maxEnding);
            }
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 7
// 5
// 1 2 3 4 5
// 4
// 9 9 8 8
// 6
// -1 4 -1 0 5 -4
// 4
// -1 2 4 -3
// 1
// -1000
// 3
// 101 -99 101
// 20
// -10 5 -8 10 6 -10 7 9 -2 -6 7 2 -4 6 -1 7 -6 -7 4 1
// OutputCopy
// 15
// 17
// 8
// 4
// -1000
// 101
// 10