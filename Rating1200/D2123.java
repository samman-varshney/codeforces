package Rating1200;
import java.util.*;

public class D2123{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            if((n%2 == 0 && 2*k > s.length()) || (n%2!=0 && k >= (s.length()+1)/2)){
                System.out.println("Alice");
            }else{
                int ones = 0;
                for(int i=0; i<n; i++){
                    if(s.charAt(i) == '1'){
                        ones++;
                    }
                }
                if(ones <= k){
                    System.out.println("Alice");
                }else{
                    System.out.println("Bob");
                }
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 5 2
// 11011
// 7 4
// 1011011
// 6 1
// 010000
// 4 1
// 1111
// 8 3
// 10110110
// 6 4
// 111111
// OutputCopy
// Bob
// Alice
// Alice
// Bob
// Bob
// Alice