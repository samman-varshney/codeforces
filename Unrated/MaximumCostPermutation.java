package Unrated;
import java.util.*;

public class MaximumCostPermutation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] idx = new int[n+1];
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                idx[arr[i]] = 1;
            }

            int i=0, j=n;
            while(i < n && j >= 1){
                while( i < n && arr[i] != 0){
                    i++;
                }
                while(j>=1 && idx[j] != 0){
                    j--;
                }
                if(i<n)arr[i] = j;
                if(j>=1)idx[j] = 1;
            }

            int left = n+1, right = -1;
            int num = 1;
            for(int k=0; k<n; k++){
                if(arr[k] !=num){
                    left = Math.min(left, k);
                    right = Math.max(right, k);
                }
                num++;
            }
            if(right == -1){
                System.out.println(0);
            }else{
                System.out.println(right - left + 1);
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 5
// 1 0 4 0 5
// 3
// 0 0 0
// 4
// 1 2 3 0
// 3
// 0 3 2
// OutputCopy
// 3
// 3
// 0
// 2