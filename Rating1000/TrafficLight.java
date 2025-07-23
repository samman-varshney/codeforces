package Rating1000;
import java.util.Scanner;
public class TrafficLight {
    public static void main(String[] args) {
        Scanner sc= new Scanner((System.in));
        int tcase = sc.nextInt();
        while(tcase-- >0){
            sc.nextInt();
            char c = sc.next().charAt(0);
            String s = sc.next();
            s  = s+s;
            int i = 0, res = 0;
            while(i<s.length()){
                while(i<s.length() && s.charAt(i)!=c)i++;
                int idx = i;
                
                while(i<s.length() && s.charAt(i)!='g')i++;
                res = Math.max(res, i-idx);
                i++;
            }
            System.out.println(res);

        }
        sc.close();
    }
}


// Example
// InputCopy
// 6
// 5 r
// rggry
// 1 g
// g
// 3 r
// rrg
// 5 y
// yrrgy
// 7 r
// rgrgyrg
// 9 y
// rrrgyyygy
// OutputCopy
// 3
// 0
// 2
// 4
// 1
// 4