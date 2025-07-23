package Unrated;
import java.util.Scanner;
public class BuyingTorches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            long ttrade = (long)Math.ceil((k*(x+y)-1.0)/(x-1.0));
           
            System.out.println("total trades: "+ttrade);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 2 1 5
// 42 13 24
// 12 11 12
// 1000000000 1000000000 1000000000
// 2 1000000000 1000000000
// OutputCopy
// 14
// 33
// 25
// 2000000003
// 1000000001999999999