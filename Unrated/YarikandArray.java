package Unrated;
import java.util.*;

public class YarikandArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int sum =0;
            int prev = 0;
            int res = Integer.MIN_VALUE;
            for(int j=0; j<n; j++){
                if(sum <= 0 || (prev == (arr[j]&1))){
                    sum =0 ;
                }
                sum+=arr[j];
                prev = (arr[j]&1);
                res = Math.max(res, sum);
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