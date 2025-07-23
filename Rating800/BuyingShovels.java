package Rating800;
import java.util.Scanner;
public class BuyingShovels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        // int r = sc.nextInt();

        if(k%10 ==0){
            System.out.println(1);
        }else{
            int rem = k % 10;
            int ans1 = 0;
            // int count = 0;
            while(ans1%10 != 0){
                ans1+=rem;
                // count++;
            }
        }
        sc.close();
    }
}
