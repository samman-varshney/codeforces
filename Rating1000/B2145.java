package Rating1000;
import java.util.*;

public class B2145{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[] s = sc.next().toCharArray();
            Arrays.sort(s);

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                res.append('+');
            }
            int start = 0, end = n-1;
            for(int i=0; i<k; i++){
                if(s[i] == '0'){
                    res.setCharAt(start++, '-');
                }else if(s[i] == '1'){
                    res.setCharAt(end--, '-');  
                }else{
                    boolean c1 = !(start-1>=0 && res.charAt(start-1) == '?');
                    boolean c2 = !(end+1 <n && res.charAt(end+1) == '?');
                    if( c1 && c2 && start == end){
                        res.setCharAt(start++, '-');
                    }else if(start > end){
                        res.setCharAt(start++, '-');
                        res.setCharAt(end--, '-');
                    }else{
                        res.setCharAt(start++, '?');
                        res.setCharAt(end--, '?');
                    }
                }
            }

            System.out.println(res.toString());

        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 4 2
// 01
// 3 2
// 22
// 1 1
// 2
// 7 5
// 01201
// OutputCopy
// -++-
// ???
// -
// --?+?--