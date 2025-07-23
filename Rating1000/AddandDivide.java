package Rating1000;
import java.util.Scanner;
public class AddandDivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            int addition = 0;
            if(b==1){
                b++;
                addition++;
            }
            long res = Integer.MAX_VALUE;
            while(true){
                int division = 0;
                long sample = a;
                while(sample>0){
                    division++;
                    sample/=b;
                }
                int total = addition+division;
                if(total > res)
                    break;
                else 
                    res = total;
                b+=1;
                addition++;
            }
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 9 2
// 1337 1
// 1 1
// 50000000 4
// 991026972 997
// 1234 5678
// OutputCopy
// 4
// 9
// 2
// 12
// 3
// 1