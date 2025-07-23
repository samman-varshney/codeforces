package Unrated;

import java.util.Scanner;
public class GreedyGrid {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if((n>1 && m>2) || (n>2 && m>1)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 2
// 3 3
// 1 2
// OutputCopy
// YES
// NO