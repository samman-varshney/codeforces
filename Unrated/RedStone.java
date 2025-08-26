package Unrated;

import java.util.*;
public class RedStone {
    
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
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(set.contains(arr[i])){
                System.out.println("YES");
                return;
            }
            set.add(arr[i]);
        }
        System.out.println("NO");

    }
}