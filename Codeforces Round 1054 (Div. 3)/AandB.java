
import java.util.*;

public class AandB{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            char[] arr = sc.next().toCharArray();
            int af=n-1, al=0;
            int bf=n-1, bl=0;
            for(int i=0; i<n; i++){
                if(arr[i] == 'a'){
                    af = Math.min(af, i);
                    al = i;
                }else{
                    bf = Math.min(bf, i);
                    bl = i;
                }
            }
            
            long counta = 0;
            int start =af, end= al;
            for(int i=af; i<=al; i++){
                if(arr[i] == 'b'){
                    if(i-start < end-i){
                        counta += i-start;
                        start++;
                    }else{
                        counta += end - i;
                        end--;
                    }
                }
            }
            long countb = 0;
            start =bf; end= bl;
            for(int i=bf; i<=bl; i++){
                if(arr[i] == 'a'){
                    if(i-start < end-i){
                        countb += i-start;
                        start++;
                    }else{
                        countb += end - i;
                        end--;
                    }
                }
            }

            System.out.println(Math.min(counta, countb));

        }
        sc.close();
    }
}
// Example
// InputCopy
// 5
// 4
// abab
// 6
// bababa
// 7
// abababa
// 2
// ab
// 1
// b
// OutputCopy
// 1
// 2
// 2
// 0
// 0