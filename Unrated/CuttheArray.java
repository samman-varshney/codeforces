package Unrated;
import java.util.*;

public class CuttheArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int totalSum = 0;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                totalSum += arr[i];
            }
            helper(arr, totalSum);
        }
        sc.close();
    }

    public static void helper(int[] arr, int sum){
        int n = arr.length;
        int prefix = 0;
        for(int i=0; i<n-2; i++){
            prefix += arr[i];
            int middle = 0;
            for(int j=i+1; j<n-1; j++){
                middle += arr[j];
                int suffix = sum - middle - prefix;
                int s1 = prefix%3;
                int s2 = middle%3;
                int s3 = suffix%3;

                if((s1 == s2 && s2 == s3 && s3 == s1) || (s1 != s2 && s2 != s3 && s3 != s1)){
                    System.out.println((i+1)+" "+(j+1));
                    return;
                }
            }
        }
        System.out.println(0+" "+0);
    }
}

// Example
// InputCopy
// 4
// 6
// 1 2 3 4 5 6
// 4
// 1 3 3 7
// 3
// 2 1 0
// 5
// 7 2 6 2 4
// OutputCopy
// 3 5
// 0 0
// 1 2
// 2 4