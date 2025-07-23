package Rating1000;
import java.util.Scanner;
import java.util.Arrays;
public class Monsters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                arr[i][0] = i;
                arr[i][1] = num%k == 0?k:num%k;
            }
            Arrays.sort(arr, (a, b)->(a[1]!=b[1]?b[1]-a[1]:a[0]-b[0]));
            for(int i=0; i<n; i++){
                System.out.print(arr[i][0]+1+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}


// Example
// InputCopy
// 3
// 3 2
// 1 2 3
// 2 3
// 1 1
// 4 3
// 2 8 3 5
// OutputCopy
// 2 1 3 
// 1 2 
// 3 1 2 4 