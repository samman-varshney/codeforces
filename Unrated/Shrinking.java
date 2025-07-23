package Unrated;

import java.util.Scanner;

public class Shrinking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tcase=sc.nextInt();
        while(tcase-->0){
            int n=sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(helper(arr,n));
        }
        sc.close();
    }

    private static int helper(int[] arr,int n) {
        if(arr.length==1){
            return -1;
        }
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i] - arr[i+1])<=1 ){
                return 0;
            }
        }

        int i=0;
        while (i+1<n) {
            int minVal=Math.min(arr[i], arr[i+1]);
            int maxVal=Math.max(arr[i], arr[i+1]);
            if (i - 1 >= 0 && maxVal >= arr[i-1] - 1 && minVal <= arr[i-1] + 1) {
                return 1;
            }
            if (i + 2 < n && maxVal >= arr[i+2] - 1 && minVal <= arr[i+2] + 1) {
                return 1;
            }
            i++;
        }
        return -1;
        
    }
}