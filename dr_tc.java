import java.util.*;
public class dr_tc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            String s = sc.next();
            // String other = sc.next();

            int zero = 0, ones = 0;
            for(int i=0; i<n; i++){
                if(s.charAt(i) == '0'){
                    zero++;
                }else{
                    ones++;
                }
            }
            System.out.println(ones*(ones-1) + zero*(ones+1));
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 3
// 101
// 1
// 1
// 5
// 00000
// 2
// 11
// 3
// 010
// OutputCopy
// 5
// 0
// 5
// 2
// 4