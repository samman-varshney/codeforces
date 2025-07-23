package Rating1000;

import java.util.Scanner;
public class SimpleRepeatiton {
    public static String isPrime(long num) {
        if(num == 1)return "NO";
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0)
                return "NO";
        }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int x = sc.nextInt();
            int k = sc.nextInt();

            if( x == 1){
                int num = 0;
                for(int i =0 ; i<k; i++){
                    num = num*10 + 1;
                }
                System.out.println(isPrime(num));
            }else if(k != 1){
                System.out.println("NO");
            }else{
                System.out.println(isPrime(x));
            }

        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 52 3
// 6 7
// 7 1
// 1 7
// OutputCopy
// NO
// NO
// YES
// NO


// 3 7
// 4 1
// 4 2
// 4 3