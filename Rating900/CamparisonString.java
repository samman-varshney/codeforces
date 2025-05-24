package Rating900;
import java.util.Scanner;
public class CamparisonString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            String s = sc.next();

            int res = 1;
            int count = 1;
            for(int i=1; i<n; i++){
                if(s.charAt(i) == s.charAt(i-1))
                    count++;
                else{
                    res = Math.max(res, count);
                    count=1;
                }
            }
            res = Math.max(res, count);
            System.out.println(res+1);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 4
// <<>>
// 4
// >><<
// 5
// >>>>>
// 7
// <><><><
// OutputCopy
// 3
// 3
// 6
// 2