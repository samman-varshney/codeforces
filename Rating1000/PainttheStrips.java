package Rating1000;

import java.util.Scanner;
public class PainttheStrips {
    static int solve(int n){
        if(n == 1)return 1;
        int count = 1;
        long start = 1;
        while( start < n){
            start = (start +1)*2;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 1
// 2
// 4
// 20
// OutputCopy
// 1
// 2
// 2
// 4