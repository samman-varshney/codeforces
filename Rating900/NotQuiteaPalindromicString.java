package Rating900;
import java.util.Scanner;
public class NotQuiteaPalindromicString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int gpones = 0, gpzeros = 0, bp = 0;
            int i=0, j=n-1;
            while(i < j){
                if(s.charAt(i) == s.charAt(j)){
                    if(s.charAt(i) == '0'){
                        gpzeros++;
                    }else{
                        gpones++;
                    }
                }else{
                    bp++;
                }
                i++;j--;
            }
            
            if(k == (gpones + gpzeros)){
                System.out.println("YES");
            }else if( k > gpones+gpzeros){
                int diff = k - (gpones+gpzeros);
                if(diff%2 == 0 && diff <= bp){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
                int diff = (gpones+gpzeros) - k;
                if(diff%2 == 0 && diff/2 <= Math.min(gpones, gpzeros)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
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