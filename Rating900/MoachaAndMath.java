package Rating900;
import java.util.Scanner;
public class MoachaAndMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            int res = arr[0];
            for(int i=1; i<n; i++)
                res&=arr[i];
            System.out.println(res);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 4
// 2
// 1 2
// 3
// 1 1 3
// 4
// 3 11 3 7
// 5
// 11 7 15 3 7
// OutputCopy
// 0
// 1
// 3
// 3