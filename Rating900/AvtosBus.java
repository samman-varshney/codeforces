package Rating900;
import java.util.Scanner;
public class AvtosBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long num = sc.nextLong();
            
            if(num<4 || num%2 == 1)
                System.out.println(-1);
            else{
                long min = num/6 + (num%6 == 0?0:1);
                long max = num/4 ;
                System.out.println(min+" "+max);
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 4
// 7
// 24
// 998244353998244352
// OutputCopy
// 1 1
// -1
// 4 6
// 166374058999707392 249561088499561088
