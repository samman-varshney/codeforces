package Unrated;

import java.util.*;
public class Villagers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            helper(sc);
        }
    }

    private static void helper(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n]; 
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long res = 0;
        int i = 0;
        if(arr.length % 2 == 1){
            res += arr[0];
            i++;
        }
        for( ; i < arr.length; i+=2){
            res += Math.max(arr[i], arr[i+1]);
        }
        System.out.println(res);
    }
}