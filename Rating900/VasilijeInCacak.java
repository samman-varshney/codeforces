package Rating900;
import java.util.Scanner;
public class VasilijeInCacak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long x = sc.nextLong();

            long minSum = (k*(k+1l))/2l, maxSum = (n*(n+1l))/2l - ((n-k)*(n-k+1l))/2l;
            if(x >= minSum && x <= maxSum)
                System.out.println("Yes");
            else 
                System.out.println("No");
             
        }
        sc.close();
    }
}

