package Rating1100;

import java.util.Scanner;
public class PaintTheArray {

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b){
        return (a*b)/gcd(a, b);
    }

    static long solve(long[] arr){
        int n = arr.length;
         long prev = 0;
            boolean flag = true;
            //checking odd places
            for (int i = 0; i < arr.length; i+=2) {
                long gcdOnLeft = 1;
                if(i-1 >= 0){
                    gcdOnLeft = gcd(arr[i], arr[i-1]);
                }
                long gcdOnRight = 1;
                if(i+1 <= n-1){
                    gcdOnRight = gcd(arr[i], arr[i+1]);
                }
                long lcmOfGcds = lcm(gcdOnLeft, gcdOnRight);
                prev = gcd(arr[i]/lcmOfGcds, prev);
                if(prev == 1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return prev;
            }
            prev = 0;flag = true;
            for (int i = 1; i < arr.length; i+=2) {
                long gcdOnLeft = 1;
                if(i-1 >= 0){
                    gcdOnLeft = gcd(arr[i], arr[i-1]);
                }
                long gcdOnRight = 1;
                if(i+1 <= n-1){
                    gcdOnRight = gcd(arr[i], arr[i+1]);
                }
                long lcmOfGcds = lcm(gcdOnLeft, gcdOnRight);
                prev = gcd(arr[i]/lcmOfGcds, prev);
                if(prev == 1){
                    flag = false;
                    break;
                }
            }

            if(flag){
                return prev;
            }else{
                return 0;
            }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLong();
            }

           System.out.println(solve(arr));

        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 5
// 1 2 3 4 5
// 3
// 10 5 15
// 3
// 100 10 200
// 10
// 9 8 2 6 6 2 8 6 5 4
// 2
// 1 3
// OutputCopy
// 2
// 0
// 100
// 0
// 3