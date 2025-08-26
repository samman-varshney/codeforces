package Unrated;

import java.util.Scanner;
public class AllYouNeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0  ) {
            int n = sc.nextInt();
            long sum = 0;
            int mex = 0;
            for(int i = 0; i < n; i++) {
                int num = sc.nextInt();
                sum += num;
                if( num == 0){
                    mex++;
                }
            }
            System.out.println(sum+mex);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 2
// 3
// 0 1 1
// 3
// 1 2 3
// OutputCopy
// 3
// 6