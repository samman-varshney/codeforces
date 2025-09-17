package Unrated;
import java.util.*;

public class AllLengthsSubtraction{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int idx = -1;
            int max = 0;
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                if(arr[i] > max){
                    max = arr[i];
                    idx = i;
                }
            }
            System.out.println(helper(arr, idx, max));
        }
        sc.close();
    }
    public static String helper(int[] arr, int idx, int max){
        int n = arr.length;
        int i=idx, j = idx;
            while( i != 0 || j != n-1){
                if(i-1 >= 0 && arr[i-1] == max - 1){
                    max = arr[i-1];
                    i--;
                }else if(j+1 < n && arr[j+1] == max-1){
                    max = arr[j+1];
                    j++;
                }else{
                    return "NO";
                }
            }
            return "YES";
    }
}
// InputCopy
// 4
// 4
// 1 3 4 2
// 5
// 1 5 2 4 3
// 5
// 2 4 5 3 1
// 3
// 3 1 2
// OutputCopy
// YES
// NO
// YES
// NO