package Rating900;
import java.util.Scanner;
public class NotQuitePalindromicString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase--  >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int ones = 0, zeros=0;
            for(int i=0; i<n; i++){
                if(s.charAt(i)=='1')
                    ones++;
                else    
                    zeros++;
            }
            int parity = ((n-2*k)/2)%2;
            // System.out.println(parity);
            if(parity == 0){
                System.out.println(ones%2==0&&zeros%2==0?"YES":"NO");
            }else{
                System.out.println(ones%2==1&&zeros%2==1?"YES":"No");
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 6 2
// 000000
// 2 1
// 01
// 4 1
// 1011
// 10 2
// 1101011001
// 10 1
// 1101011001
// 2 1
// 11
// OutputCopy
// NO
// NO
// YES
// NO
// YES
// YES