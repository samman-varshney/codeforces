package Rating1100;

import java.util.Scanner;
public class PerfectlyBalancedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            String s = sc.next();
            int n = s.length();
            int[] idx = new int[26];
            int i=0;
            String match = "";
            while(i<n && idx[s.charAt(i)-'a'] == 0){
                match+=s.charAt(i);
                idx[s.charAt(i)-'a'] = i+1;
                i++;
            }
            boolean flag = true;
            while(i < n){
                int j = i, k=0;
                while( j<n && k<match.length()){
                    if(match.charAt(k) != s.charAt(j)){
                        flag = false;
                        break;
                    }
                    j++;k++;
                }
                if(!flag)
                    break;
                i=j; 
            }

            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// aba
// abb
// abc
// aaaaa
// abcba
// OutputCopy
// YES
// NO
// YES
// YES
// NO