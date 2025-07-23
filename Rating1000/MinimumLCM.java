package Rating1000;
import java.util.Scanner;
public class MinimumLCM {
    public static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

    public static int compute(int prod, int gcd){
        return prod/gcd;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int num = sc.nextInt();
            if(num%2 == 0)
                System.out.println(num/2+" "+num/2);
            else{
                int res = Integer.MAX_VALUE, a=1;
                int sqrt = (int)Math.ceil(Math.sqrt(num));
                for(int i=1; i<=sqrt; i++){
                    if(num%i == 0){
                        int lcm = compute(i*(num-i), gcd(i, num-i));
                        if(res > lcm){
                            res = lcm;
                            a = i;
                        }
                        int q = num%i;
                        lcm = compute(q*(num-q), gcd(q, num-q));
                        if(res > lcm){
                            res = lcm;
                            a = i;
                        }
                    }
                    
                }
                System.out.println(a+" "+(num-a));
            }
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 2
// 9
// 5
// 10
// OutputCopy
// 1 1
// 3 6
// 1 4
// 5 5