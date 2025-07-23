package Rating900;

import java.util.Scanner;
public class NotDividing{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
           
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                if(num == 1){
                  
                    num++;
                }
                arr[i] = num;
            }
            for(int i=1; i<n; i++){
                if(arr[i]%arr[i-1]==0){
                  
                    arr[i]++;
                }
            }
            for(int x :arr )
                System.out.print(x+" ");
            System.out.println();
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 4
// 2 4 3 6
// 3
// 1 2 3
// 2
// 4 2
// OutputCopy
// 4 5 6 7
// 3 2 3
// 4 2