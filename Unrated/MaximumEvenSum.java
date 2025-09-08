package Unrated;
import java.util.Scanner;
public class MaximumEvenSum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long a = sc.nextLong();
            long b = sc.nextLong();

            if(b%2 == 0){
                long ans = a*(b/2) + 2;
                if(ans%2 == 0){
                    System.out.println(ans);
                }else{
                    System.out.println(-1);
                }
            }else{
                if(a%2 == 0){
                    System.out.println(-1); 
                }else{
                    System.out.println(a*b + 1);
                }
            }
        }
        sc.close();
    }
}



// Example
// InputCopy
// 7
// 8 1
// 1 8
// 7 7
// 2 6
// 9 16
// 1 6
// 4 6
// OutputCopy
// -1
// 6
// 50
// 8
// 74
// -1
// 14