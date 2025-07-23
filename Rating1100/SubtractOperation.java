package Rating1100;

import java.util.Scanner;

public class SubtractOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            if((sum-k)%n == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
