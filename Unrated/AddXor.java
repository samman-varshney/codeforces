package Unrated;

import java.util.Scanner;
public class AddXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

            if( a > b){
                if( (a^1) == b)
                    System.out.println(y);
                else
                    System.out.println(-1);
            }else{
                long res = 0;
                while(a < b){
                    if(a%2 == 0){
                        res += Math.min(x, y);
                    }else{
                        res += x;
                    }
                    a++;
                }
                System.out.println(res);
            }
        }
        sc.close();
    }
}


// Example
// InputCopy
// 7
// 1 4 1 2
// 1 5 2 1
// 3 2 2 1
// 1 3 2 1
// 2 1 1 2
// 3 1 1 2
// 1 100 10000000 10000000
// OutputCopy
// 3
// 6
// 1
// 3
// -1
// -1
// 990000000