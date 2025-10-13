package Rating1200;
import java.util.*;

public class C2134{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            long ans = 0;
            for(int i=1; i<n; i+=2){
                if(i-1 >=0 && arr[i] < arr[i-1]){
                    ans += arr[i-1] - arr[i];
                    arr[i-1] = arr[i];
                }
                if(i+1<n && arr[i] < arr[i+1]){
                    ans += arr[i+1] - arr[i];
                    arr[i+1] = arr[i];
                }
                if(i-1>=0 && i+1<n && arr[i+1]+arr[i-1] > arr[i]){
                    int diff = arr[i-1]+arr[i+1]-arr[i];
                    ans += diff;
                    arr[i+1] = Math.max(arr[i+1]-diff, 0);
                    diff -= arr[i+1];
                    arr[i-1] = Math.max(arr[i-1]-diff, 0);
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 8
// 4
// 3 8 4 4
// 4
// 0 2 3 5
// 2
// 3 1
// 5
// 2 3 1 4 2
// 4
// 0 2 4 1
// 5
// 3 1 4 5 1
// 11
// 3 0 5 4 4 5 3 0 3 4 1
// 12
// 410748345 10753674 975233308 193331255 893457280 279719251 704970985 412553354 801228787 44181004 1000000000 3829103
// OutputCopy
// 0
// 1
// 2
// 0
// 3
// 6
// 14
// 4450984776