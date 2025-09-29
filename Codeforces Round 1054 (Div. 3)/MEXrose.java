
import java.util.*;

public class MEXrose{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                if(num < n){
                    arr[num] += 1;
                }
            }
            int count = 0;
            for(int i=0; i<k; i++){
                if(arr[i] == 0)
                    count++;
            }
            if(k < n){
                if(arr[k] >= 1)
                    count += count >= arr[k]? 0: arr[k]-count;
            }
            System.out.println(count);
        }
        sc.close();
    }
}
// InputCopy
// 5
// 1 0
// 0
// 3 1
// 0 2 3
// 5 5
// 0 1 2 3 4
// 6 2
// 0 3 4 2 6 2
// 7 4
// 0 1 5 4 4 7 3
// OutputCopy
// 1
// 0
// 0
// 2
// 2