package Rating1200;

import java.util.Scanner;
public class MakeThemEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            String s = sc.next();
            boolean btw0N = false;
            for(int i=0; i<n-1; i++){
                if(s.charAt(i)  != c){
                    btw0N = true;
                    break;
                }
            }
            if(btw0N && s.charAt(n-1) != c) {
                System.out.println(2);;
                System.out.println((n/2+1+" "+n));
            } else if(btw0N) {
                System.out.println(1);
                System.out.println(n);
            }else{
                System.out.println(0);
            }
        }
        sc.close();
    }
}
// Example
// InputCopy
// 3
// 4 a
// aaaa
// 4 a
// baaa
// 4 b
// bzyx
// 3 c
// ucg
// OutputCopy
// 0
// 1
// 2
// 2 
// 2 3
// 1
// 2