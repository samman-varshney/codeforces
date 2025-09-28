package Unrated;
import java.util.*;

public class EqualOccurrences{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int[] size = new int[101];
            int count = 0;
            int prev = arr[0];
            for(int i=0; i<n; i++){
                if(arr[i] == prev){
                    count++;
                }else{
                   size[count]++;
                    count = 1;
                    prev = arr[i];
                }
            }
           size[count]++;

            int max = 0;
            for(int i=1; i<size.length; i++){
                int len = 0;
                for(int j=i; j<size.length; j++){
                    len += i*size[j];
                }
                max = Math.max(max, len);
            }
            System.out.println(max);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 5
// 1 1 4 4 4
// 2
// 1 2
// 15
// 1 1 1 1 1 2 2 2 2 3 3 3 4 4 5
// 5
// 3 3 3 3 3
// OutputCopy
// 4
// 2
// 9
// 5