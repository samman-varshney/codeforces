package Unrated;
import java.util.*;

public class Rabbits{
    static HashMap<String, Boolean> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            
            int n = sc.nextInt();
            String s = sc.next();
            map = new HashMap<>();  
            System.out.println(helper(0, n-1, s)?"YES":"NO");
            
        }
        sc.close();
    }

    public static boolean helper(int start, int end, String s){
        String key = start+","+end;
        if(map.containsKey(key))
            return map.get(key);

        int count = 0;
        boolean consecutive = false;
        for(int i=start; i<=end; i++){
            if(i!=start && s.charAt(i) == '1' && s.charAt(i-1) == '1'){
                boolean res = helper(start, i-1, s) && helper(i, end, s) ;
                map.put(key, res);
                return res;
            }
            if(s.charAt(i) == '0'){
                count++;
                if(i!=0 && s.charAt(i-1)=='0'){
                    consecutive = true;
                }
            }
        }
        
        boolean res = consecutive || count%2 ==0 || s.charAt(end)=='0' || s.charAt(start)=='0';
        map.put(key, res);
        return res;
    }
}


// Example
// InputCopy
// 12
// 4
// 0100
// 3
// 000
// 8
// 11011011
// 5
// 00100
// 1
// 1
// 5
// 01011
// 2
// 01
// 7
// 0101011
// 7
// 1101010
// 5
// 11001
// 4
// 1101
// 9
// 001101100
// OutputCopy
// YES
// YES
// NO
// YES
// YES
// YES
// YES
// YES
// YES
// YES
// NO
// NO
