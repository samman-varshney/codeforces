package Rating1000;
import java.util.Scanner;
import java.util.Arrays;

public class DistinctSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            String s = sc.next();

            int[] ltr = new int[n];
            int[] rtl = new int[n];

            int[] set = new int[26];
            int cnt = 0;
            for(int i=0; i<n; i++){
                char c = s.charAt(i);
                if(set[c-'a']==0){
                    cnt++;
                    set[c-'a']=1;
                }
                ltr[i] = cnt;
            }
            Arrays.fill(set, 0);
            cnt = 0;
            for(int i=n-1; i>=0; i--){
                char c = s.charAt(i);
                if(set[c-'a']==0){
                    cnt++;
                    set[c-'a']=1;
                }
                rtl[i] = cnt;
            }

            
            int a=0, b=0;
            for(int i=0; i<n-1; i++){
                if(a+b < ltr[i]+rtl[i+1]){
                    a = ltr[i];
                    b = rtl[i+1];
                }
            }
            System.out.println(a+b);

        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 2
// aa
// 7
// abcabcd
// 5
// aaaaa
// 10
// paiumoment
// 4
// aazz
// OutputCopy
// 2
// 7
// 2
// 10
// 3