package Rating900;
import java.util.Scanner;
public class SwapandDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            String s = sc.next();
            int ones =0;
            int zeros =0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0')
                    zeros++;
                else    
                    ones++;
            }
            int res = 0;
            for(int i=0; i<s.length(); i++){
                if((s.charAt(i) == '0' && ones >0) || (s.charAt(i) == '1' && zeros >0)){
                    res++;
                    if(s.charAt(i) == '0')
                        ones--;
                    else
                        zeros--;
                }else{
                    break;
                }
            }
            System.out.println(s.length()-res);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 0
// 011
// 0101110001
// 111100
// OutputCopy
// 1
// 1
// 0
// 4