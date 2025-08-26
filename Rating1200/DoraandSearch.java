package Rating1200;

import java.util.Scanner;
public class DoraandSearch {
    static String helper(int[] arr){
        int n = arr.length;
        if( n <= 3)
            return "-1";
        
        int i=1, j=n-2;
        while( i < j){
            if(arr[i] < arr[j]){
                if(arr[i] < arr[i-1] && arr[j] > arr[j+1] && arr[j+1] > arr[i] && arr[i-1] < arr[j]){
                    return i + " " + (j+2);
                }
                if(arr[i] > arr[i-1]){
                    i++;
                }
                if(arr[j] < arr[j+1]){
                    j--;
                }
            }else{
                if(arr[i] > arr[i-1] && arr[j] < arr[j+1] && arr[j+1] < arr[i] && arr[i-1] > arr[j]){
                    return i + " " + (j+2);
                }
                if(arr[i] < arr[i-1]){
                    i++;
                }
                if(arr[j] > arr[j+1]){
                    j--;
                }
            }
        }
        return "-1";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(helper(arr));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 3
// 1 2 3
// 4
// 2 1 4 3
// 7
// 1 3 2 4 6 5 7
// 6
// 2 3 6 5 4 1
// OutputCopy
// -1
// 1 4
// 2 6
// -1