package Rating900;
import java.util.Scanner;
public class LongestDivisorsInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long n = sc.nextLong();
            int i = 1;
            while(n%i==0){
                i++;
            }
            System.out.println(i-1);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 10
// 1
// 40
// 990990
// 4204474560
// 169958913706572972
// 365988220345828080
// 387701719537826430
// 620196883578129853
// 864802341280805662
// 1000000000000000000
// OutputCopy
// 1
// 2
// 3
// 6
// 4
// 22
// 3
// 1
// 2
// 2