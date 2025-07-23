package Rating900;
import java.util.Scanner;
public class Raspberries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int res = Integer.MAX_VALUE;

            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                res = Math.min(res, num%k==0?0:k-num%k);
            }
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 15
// 2 5
// 7 3
// 3 3
// 7 4 1
// 5 2
// 9 7 7 3 9
// 5 5
// 5 4 1 2 3
// 7 4
// 9 5 1 5 9 5 1
// 3 4
// 6 3 6
// 3 4
// 6 1 5
// 3 4
// 1 5 9
// 4 4
// 1 4 1 1
// 3 4
// 3 5 3
// 4 5
// 8 9 9 3
// 2 5
// 1 6
// 2 5
// 10 10
// 4 5
// 1 6 1 1
// 2 5
// 7 7
// OutputCopy
// 2
// 2
// 1
// 0
// 2
// 0
// 1
// 2
// 0
// 1
// 1
// 4
// 0
// 4
// 3
