package Rating1100;

import java.util.Scanner;
import java.util.Arrays;

public class SubsequenceAddition {
    public static String solve(int[] arr, int n){
        if(arr[0] != 1){
            return "NO";
        }
        long runningSum = 1;
        for(int i=1; i<n; i++){
            if(arr[i] > runningSum){
                return "NO";
            }
            runningSum+=arr[i];
        }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(solve(arr, n));
        }
        sc.close();
    }
}
