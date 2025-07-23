package Unrated;
import java.util.Scanner;
public class HalloumiBoxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            boolean isSorted = true;
            int prev = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                if(arr[i] < prev){
                    isSorted = false;
                }
                prev = arr[i];
            }
            
            if(k >= 2 || isSorted)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}
