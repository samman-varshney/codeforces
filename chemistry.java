import java.util.*;
public class chemistry {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int[] freq = new int[26];
            for(int i=0; i<n; i++){
                freq[s.charAt(i)-'a']++;
            }
            int odd = 0;
            for(int x : freq){
                if(x%2 != 0)
                    odd++;
            }

            System.out.println(k>=odd-1?"Yes":"No");
        }
        sc.close();
    }
}

// Example
// InputCopy
// 14
// 1 0
// a
// 2 0
// ab
// 2 1
// ba
// 3 1
// abb
// 3 2
// abc
// 6 2
// bacacd
// 6 2
// fagbza
// 6 2
// zwaafa
// 7 2
// taagaak
// 14 3
// ttrraakkttoorr
// 5 3
// debdb
// 5 4
// ecadc
// 5 3
// debca
// 5 3
// abaac
// OutputCopy
// YES
// NO
// YES
// YES
// YES
// YES
// NO
// NO
// YES
// YES
// YES
// YES
// NO
// YES