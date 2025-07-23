package Rating1100;

import java.util.Scanner;
import java.util.Arrays;
public class DejaVu {

    public static int power(long num) {
        int start = 0, end = 30;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num % (1 << mid) == 0) {
                
                start = mid + 1; 
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int q = sc.nextInt();

            long[][] a = new long[n][3];
            int[] x = new int[q];

            for(int i=0; i<n; i++){
                a[i][0] = i;
                a[i][1] = sc.nextInt();
                a[i][2] = power(a[i][1]);
            }
            
        
            for(int i=0; i<q; i++){
                x[i] = sc.nextInt();
            }
            Arrays.sort(a, (o1, o2)->{
                return (int)(o1[2] - o2[2]);
            });
            Arrays.sort(x);
            long[] prefix = new long[q];
            prefix[0] = (long)Math.pow(2, x[0]-1);
            for(int i=1; i<q; i++){
                prefix[i] = (long)Math.pow(2, x[i]-1) + prefix[i-1];
            }

            long highest = a[a.length-1][2];
            int start = 0, end = q-1;
            while(start <= end){
                int mid = (end - start)/2 + start;
                if(x[mid] <= highest){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            int idx = end;
            int k = a.length-1;
            while( idx >= 0 && k>=0 && a[k][2]!=0){
                if(a[k][1]%(1<<x[idx]) == 0){
                    a[k][1] += prefix[idx];
                    k--;
                }else{
                    idx--;
                }
            }
            Arrays.sort(a, (o1, o2)->{
                return (int)(o1[0] - o2[0]);
            });
            for(int i=0; i<n; i++){
                System.err.print(a[i][1]+" ");
            }
            System.err.println();
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 5 3
// 1 2 3 4 4
// 2 3 4
// 7 3
// 7 8 12 36 48 6 3
// 10 4 2
// 5 4
// 2 2 2 2 2
// 1 1 1 1
// 5 5
// 1 2 4 8 16
// 5 2 3 4 1
// OutputCopy
// 1 2 3 6 6 
// 7 10 14 38 58 6 3 
// 3 3 3 3 3 
// 1 3 7 11 19 