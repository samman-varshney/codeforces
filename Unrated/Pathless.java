package Unrated;

import java.util.Scanner;
public class Pathless {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int twos =0, ones = 0;
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                if(arr[i] == 1) ones++;
                else if(arr[i] == 2) twos++;
            }
            if(ones + 2 * twos > s){
                for(int i=0; i<n; i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }else if( ones + 2 * twos == s){
                System.out.println(-1);
            }else if(ones + 2 * twos - s == 1){
                
            }
        }
        sc.close();
    }
}
