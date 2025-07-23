package Rating1200;

import java.util.Scanner;
public class Retaliation {
    public static boolean solve(int[] arr){
        int n = arr.length;
        //check for acesnding
        boolean isAsce = true;
        for(int i=0; i<n-1; i++){
            if(arr[i+1]%arr[i] != 0){
                isAsce = false;
                break;
            }
        }
        if(isAsce)return true;
        //if it can be converted to ascending
        for(int i=n-1; i>0; i--){
            
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
      
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                
            }

            

            
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 4
// 3 6 6 3
// 5
// 21 18 15 12 9
// 10
// 2 6 10 2 5 5 1 2 4 10
// 7
// 10 2 16 12 8 20 4
// 2
// 52 101
// 2
// 10 2
// OutputCopy
// NO
// YES
// NO
// NO
// YES
// NO