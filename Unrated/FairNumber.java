package Unrated;
import java.util.Scanner;

public class FairNumber {
    public static boolean iFair(long n){
        long dup = n;
        while(dup > 0){
            long rem = dup%10;
            if(rem != 0 && n%rem != 0)
                return false;
            dup /= 10;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long n = sc.nextLong();
            
            while(true){
                
                if(iFair(n)){
                    System.out.println(n);
                    break;
                }
                n++;
            }
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 1
// 282
// 1234567890
// 1000000000000000000
// OutputCopy
// 1
// 288
// 1234568040
// 1000000000000000000