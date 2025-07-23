package Rating1000;
import java.util.Scanner;
public class MoveBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            String s = sc.next();
            int open = 0, rearrange = 0;
            for(int i=0; i<n; i++){
                if(s.charAt(i) == '(') {
                    open++;
                } else {
                    open--;
                    if(open < 0) {
                        while(i < n && s.charAt(i) == ')') {
                            i++;
                            rearrange++;
                        }
                        open = 1;
                        
                    }
                }
            }
            System.out.println(rearrange);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 4
// 2
// )(
// 4
// ()()
// 8
// ())()()(
// 10
// )))((((())
// OutputCopy
// 1
// 0
// 1
// 3