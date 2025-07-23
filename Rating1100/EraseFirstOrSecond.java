package Rating1100;

import java.util.Scanner;
import java.util.Arrays;
public class EraseFirstOrSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            String s = sc.next();

            int[] recent = new int[26];
            Arrays.fill(recent, n);

            int res = 0;

            for(int i=n-1; i>=0; i--){
                char c = s.charAt(i);
                int lastOccur = recent[c-'a'];
                res+= lastOccur - i;
                recent[c-'a'] = i;
            }

            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 5
// aaaaa
// 1
// z
// 5
// ababa
// 14
// bcdaaaabcdaaaa
// 20
// abcdefghijklmnopqrst
// OutputCopy
// 5
// 1
// 9
// 50
// 210
