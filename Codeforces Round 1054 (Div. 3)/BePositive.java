
import java.util.*;

public class BePositive{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int neg = 0, zeros = 0;
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                if(num == -1){
                    neg++;
                }else if(num == 0){
                    zeros++;
                }
            }
            System.out.println(2*(neg%2)+zeros);
        }
        sc.close();
    }
}