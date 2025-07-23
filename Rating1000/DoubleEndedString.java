package Rating1000;
import java.util.Scanner;
public class DoubleEndedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            String a = sc.next();
            String b = sc.next();
            int res = a.length()+b.length();
            for(int i=0; i<a.length(); i++){
                for(int j=0; j<b.length(); j++){
                    if(a.charAt(i)==b.charAt(j)){
                        int k = i, l=j;
                        while(k<a.length() && l<b.length() && a.charAt(k)==b.charAt(l)){
                            k++;l++;}
                        res = Math.min(res, a.length()-(k-i) + b.length()-(l-j));
                    }
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 5
// a
// a
// abcd
// bc
// hello
// codeforces
// hello
// helo
// dhjakjsnasjhfksafasd
// adjsnasjhfksvdafdser
// OutputCopy
// 0
// 2
// 13
// 3
// 20