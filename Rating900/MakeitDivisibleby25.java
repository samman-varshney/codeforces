package Rating900;
import java.util.Scanner;
public class MakeitDivisibleby25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            String s = sc.next();
            int zero2;
            int i=s.length()-1;
            while(i>=0 && s.charAt(i)!='0')
                i--;
            i--;
            while(i>=0 && s.charAt(i)!='0' && s.charAt(i)!='5')
                i--;
            zero2 = i;

            int five2;
            i=s.length()-1;
            while(i>=0 && s.charAt(i)!='5')
                i--;
            i--;
            while(i>=0 && s.charAt(i)!='2' && s.charAt(i)!='7')
                i--;
            five2=i;

            int rz =  s.length()-2-zero2;
            int rf = s.length()-2 -five2;
            System.out.println(Math.min(rz, rf));
            
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 100
// 71345
// 3259
// 50555
// 2050047
// OutputCopy
// 0
// 3
// 1
// 3
// 2