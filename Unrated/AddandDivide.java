package Unrated;
import java.util.Scanner;
public class AddandDivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int op = 0;
            if(b == 1){
                op++;
                b = 2;
            }
            int prev = 10000;
            while(true){
                
                int sample = a;
                int steps = 0;
                while(sample > 0){
                    sample/=b;
                    steps++;
                }
                if(steps + op >= prev){
                    break;
                }
                prev = steps + op;
                op++;
                b++;
                
            }
            
            System.out.println(prev);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 6
// 9 2
// 1337 1
// 1 1
// 50000000 4
// 991026972 997
// 1234 5678
// OutputCopy
// 4
// 9
// 2
// 12
// 3
// 1