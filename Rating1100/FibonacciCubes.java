package Rating1100;

import java.util.Scanner;
public class FibonacciCubes {
    static int[] Fibonacci = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int min = Fibonacci[n-1], max = min+ Fibonacci[n-2];
            StringBuilder res = new StringBuilder();
            for(int i=0; i<m; i++){
                int mind = Integer.MAX_VALUE, maxd = Integer.MIN_VALUE;
                for(int j=0; j<3; j++){
                    int dimension = sc.nextInt();
                    mind = Math.min( mind, dimension );
                    maxd = Math.max( maxd, dimension );
                }
                if( mind>= min && maxd>=max){
                    res.append('1');
                }else{
                    res.append('0');
                }
            }
            System.out.println(res.toString());

        }
        sc.close();
    }
}

// Example
// InputCopy
// 2
// 5 4
// 3 1 2
// 10 10 10
// 9 8 13
// 14 7 20
// 2 6
// 3 3 3
// 1 2 1
// 2 1 2
// 3 2 2
// 2 3 1
// 3 2 4
// OutputCopy
// 0010
// 100101