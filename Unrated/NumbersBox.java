package Unrated;
import java.util.Scanner;
public class NumbersBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int min = 1000000;
            int noOfOdd = 0;
            int sum = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    int x = sc.nextInt();
                    if(x < 0){
                        x = -x;
                        noOfOdd++;
                    }
                    sum += x;
                    if(x < min) min = x;
                }
            }
            System.out.println(sum - 2 * min * (noOfOdd % 2));
        }
        sc.close();
    }
}


// Example
// InputCopy
// 2
// 2 2
// -1 1
// 1 1
// 3 4
// 0 -1 -2 -3
// -1 -2 -3 -4
// -2 -3 -4 -5
// OutputCopy
// 2
// 30