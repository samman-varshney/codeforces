package Rating1100;

import java.util.Scanner;
public class Kalindrome {
    static String solve(int[] arr){
        int n = arr.length;
        int criminal = -1;
        int i=0, j=n-1;
        while(i<=j){
            if(arr[i] == arr[j]){
                i++;j--;
            }else if(criminal != -1){
                if(criminal == arr[i]){
                    i++;
                }else if(criminal == arr[j]){
                    j--;
                }else{
                    return "NO";
                }
            }else{
                // check on right for criminal
                boolean flag= true;
                int k=j-1;
                while( k>=i && arr[k] == arr[j]){
                    k--;
                }
                if(arr[k] != arr[i])
                    flag = false;
                
                if(flag){
                    criminal = arr[j];
                    j = k;
                }else{
                    //checking for criminal on left
                    k = i+1;
                    while(i<=j && arr[k] == arr[i])
                        k++;
                    if(arr[k] != arr[j]){
                        return "NO";
                    }
                    criminal = arr[i];
                    i = k;
                }
                
            }
        }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(arr));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 1
// 1
// 2
// 1 2
// 3
// 1 2 3
// 5
// 1 4 4 1 4
// OutputCopy
// YES
// YES
// NO
// YES