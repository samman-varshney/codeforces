package Unrated;
import java.util.Scanner;
public class GellyfishandTricolorPansy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            if(Math.min(a, c) >= Math.min(b, d))
                System.out.println("Gellyfish");
            else
                System.out.println("Flower");

        }
        sc.close();
    }
}
// Example
// InputCopy
// 5
// 1 2 3 4
// 100 999 1 1
// 10 20 10 30
// 12 14 13 11
// 998 244 353 107
// OutputCopy
// Flower
// Gellyfish
// Flower
// Gellyfish
// Gellyfish