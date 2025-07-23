package Rating1100;

import java.util.Scanner;
public class SorttheSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                
                b[i] = sc.nextInt();
                if(b[i] == a[i]){
                    a[i] = -1;
                }
            }
            int i=0;
            while(i<n){
                if(a[i] != -1)
                    break;
                i++;
            }

            if(i == n){
                System.out.println(n);
            }else{      
            
                // find the l
                int l = i;
                while( l>0){
                    if(b[l-1] > b[l] ){
                        break;
                    }
                    l--;
                }

                //finding r
                int r = i;
                while( r < n-1){
                    if( b[r] > b[r+1]){
                        break;
                    }
                    r++;
                }   

                System.out.println((l+1)+" "+(r+1));
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 7
// 6 7 3 4 4 6 5
// 6 3 4 4 7 6 5
// 3
// 1 2 1
// 1 1 2
// 3
// 2 2 1
// 2 1 2
// OutputCopy
// 2 5
// 1 3
// 2 3