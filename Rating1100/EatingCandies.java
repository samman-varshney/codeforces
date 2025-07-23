package Rating1100;

import java.util.Scanner;
public class EatingCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int i=-1, j=n;
            int total =0 ;
            long leftWt = 0, rightWt = 0;
            while(i<j){
                if(leftWt == rightWt){
                    total = (n - (j-i-1));
                    i++;j--;
                    leftWt += arr[i];
                    rightWt += arr[j];
                }else if(leftWt > rightWt){
                    j--;
                    rightWt += arr[j];
                }else{
                    i++;
                    leftWt += arr[i];
                }
            }
             System.out.println(total);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 3
// 10 20 10
// 6
// 2 1 4 2 4 1
// 5
// 1 2 4 8 16
// 9
// 7 3 20 5 15 1 11 8 10
// OutputCopy
// 2
// 6
// 0
// 7