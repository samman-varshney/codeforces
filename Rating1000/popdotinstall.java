package Rating1000;
import java.util.*;
public class popdotinstall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i=0; i<n; i++){
                arr[i][0] = i+1;
                arr[i][1] = sc.nextInt();
            }
            Arrays.sort(arr, (a, b)->(a[1]-b[1]));
            ArrayList<int[]> res = new ArrayList<>();
            res.add(new int[]{0, 0});
      
            for(int i=n-1; i>=0; i--){
                if((i&1) == 0)
                    res.add(0, arr[i]);
                else
                    res.add(arr[i]);
            }
            // for(int i=0; i<=n; i++)
            //     System.out.print(Arrays.toString(res.get(i))+" ");
            int idx = 0;
            for(int i=0; i<=n; i++)
                if(res.get(i)[0] == 0){
                    idx = i;
                    break;
                }
            int time = 0;
            for(int i=0; i<=n; i++){
                time += 2*res.get(i)[1]*Math.abs(i- idx);
            }
            System.out.println(time);
            int[][] last = new int[n+1][2];
            for(int i=0; i<=n; i++){
                last[i][0] = i;
                last[i][1] = res.get(i)[0];
            }
            Arrays.sort(last, (a,b)->(a[1]-b[1]));
            for(int i=0; i<=n; i++){
                System.out.print(last[i][0]+" ");
            }
            System.out.println();

        }
        sc.close();
    }
    
}


// Example
// InputCopy
// 4
// 3
// 1 2 3
// 5
// 3 8 10 6 1
// 5
// 1 1 1 1 1
// 1
// 0
// OutputCopy
// 14
// 2 4 1 3
// 78
// 1 -1 0 2 3 4
// 18
// 3 6 1 5 2 4
// 0
// 1 2