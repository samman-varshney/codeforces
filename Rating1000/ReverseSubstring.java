package Rating1000;
import java.util.Scanner;
public class ReverseSubstring {
    public static String helper(String s, int n) {
        for(int i=1; i<n; i++){
            if(s.charAt(i) < s.charAt(i-1))
                return "YES \n" + (i) + " " + (i+1);
        }
        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(helper(s, n));
        sc.close();
    }
}
