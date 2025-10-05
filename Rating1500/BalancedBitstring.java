package Rating1500;
import java.util.*;

public class BalancedBitstring{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
          
            String s = sc.next();
            System.out.println(helper(n, k, s));
        }
        sc.close();
    }


    public static String helper(int n, int k, String str){
        StringBuilder s = new StringBuilder(str);
        int ones = 0;
        int zeros = 0;

        for(int i=0; i<k; i++){
            if(s.charAt(i) == '0')
                zeros++;
            else if(s.charAt(i) == '1')
                ones++;
        }

        if(ones > k/2 || zeros > k/2)
            return "NO";
        int i=0, j=k;
        while(j<n){
            if(s.charAt(i) == s.charAt(j)){
                
            }else if(s.charAt(j) == '?'){
                s.setCharAt(j, s.charAt(i));
                
            }else if(s.charAt(i) == '?'){
                if(s.charAt(j)=='1'){
                    ones++;
                }else{
                    zeros++;
                }

                if(ones>k/2 || zeros>k/2)
                    return "NO";
                
            }else{
                return "NO";
            }
            i++; j++;
        }
        return "YES";
    }
}


// Example
// InputCopy
// 9
// 6 4
// 100110
// 3 2
// 1?1
// 3 2
// 1?0
// 4 4
// ????
// 7 4
// 1?0??1?
// 10 10
// 11??11??11
// 4 2
// 1??1
// 4 4
// ?0?0
// 6 2
// ????00
// OutputCopy
// YES
// YES
// NO
// YES
// YES
// NO
// NO
// YES
// NO
