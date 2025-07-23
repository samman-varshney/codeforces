package Rating900;
import java.util.Scanner;
public class SquareYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int year = Integer.parseInt(sc.next());
            int sqrt = (int)Math.floor(Math.sqrt(year));
            if(((int)(Math.pow(sqrt, 2)))==year){
                if(sqrt == 0)
                    System.out.println(0+" "+0);
                else if(sqrt == 1)
                    System.out.println(0+" "+1);
                else
                    System.out.println((sqrt-1)+" "+1);
            }else{
                System.out.println(-1);
            }
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 0001
// 1001
// 1000
// 4900
// 2025
// OutputCopy
// 0 1
// -1
// -1
// 34 36
// 20 25