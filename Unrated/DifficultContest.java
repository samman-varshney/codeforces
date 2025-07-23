package Unrated;

import java.util.Scanner;
public class DifficultContest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            String s = sc.next();
            int n = s.length();
            StringBuilder common = new StringBuilder();
            StringBuilder ts = new StringBuilder();
            StringBuilder fns = new StringBuilder();

            for(int i=0; i<n; i++){
                char c = s.charAt(i);
                if(c == 'N' || c == 'F'){
                    fns.append(c);
                }else if(c == 'T'){
                    ts.append(c);
                }else{
                    common.append(c);
                }
            }
            System.out.println(ts+""+common+""+fns);
        }
        sc.close();
    }
    
}
// Example
// InputCopy
// 5
// FFT
// ABFBANTTA
// FFTNTT
// FFTFFTFFTNNTNNT
// AFFTBFFNTTFTTZ
// OutputCopy
// FTF
// ABFBANATT
// NTFTFT
// TFFFFFFNTNTNTNT
// AFTFBTTFFNFTTZ
