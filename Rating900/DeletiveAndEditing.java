package Rating900;
import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.StringBuilder;
public class DeletiveAndEditing {
    public static boolean helper(String word, String target){
        char[] wrd = word.toCharArray();
        char[] tar = target.toCharArray();
        int[] wfreq = new int[26];
        int[] tfreq = new int[26];
        for (char c : wrd) {
            wfreq[c-'A']++;
        }
        for(char c : tar){
            tfreq[c-'A']++;
        }
        for(int i=0; i<26; i++){
            if(wfreq[i] < tfreq[i])
                return false;
            int diff = wfreq[i]-tfreq[i];
            char c = (char)(i+'A');
            for(int j=0; j<wrd.length && diff>0; j++)
                if(wrd[j] == c){
                    wrd[j] ='_';
                    diff--;
                }
        }

        StringBuilder s = new StringBuilder();
        for(char c : wrd)
            if(c != '_')
                s.append(c);
            
        return target.equals(s.toString());
       

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            String word = sc.next();
            String target = sc.next();

            System.out.println(helper(word, target)?"YES":"NO");
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// DETERMINED TRME
// DETERMINED TERM
// PSEUDOPSEUDOHYPOPARATHYROIDISM PEPA
// DEINSTITUTIONALIZATION DONATION
// CONTEST CODE
// SOLUTION SOLUTION
// OutputCopy
// YES
// NO
// NO
// YES
// NO
// YES