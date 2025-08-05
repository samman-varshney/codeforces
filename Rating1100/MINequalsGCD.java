package Rating1100;

import java.util.*;
public class MINequalsGCD {
    static long GCD(long a, long b){
        while(b!=0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            long min = Long.MAX_VALUE;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextLong();
                min = Math.min(min, arr[i]);
            }
            ArrayList<Long> multiples = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(arr[i]%min == 0){
                    multiples.add(arr[i]);
                }
            }
            if(multiples.size() == 1){
                System.out.println("NO");
            }else{
                Collections.sort(multiples);
                long gcd = 0;
                for(int i=1; i<multiples.size(); i++){
                    gcd = GCD(gcd, multiples.get(i)/min);
                }
                if(gcd == 1){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
        sc.close();
    }
}
// Example
// InputCopy
// 7
// 2
// 1 1
// 2
// 1 2
// 3
// 2 2 3
// 3
// 2 3 4
// 5
// 4 5 6 9 3
// 3
// 998244359987710471 99824435698771045 1000000007
// 6
// 1 1 4 5 1 4
// OutputCopy
// Yes
// No
// Yes
// No
// Yes
// Yes
// Yes

// 4
// 3 6 2 7
// NO