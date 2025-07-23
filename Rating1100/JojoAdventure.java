package Rating1100;

import java.util.Scanner;
public class JojoAdventure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0){
            String s = sc.next();
            int n = s.length();
            long[] oneOnleft = new long[n];
            long[] oneOnright = new long[n];

            long prev = 0;
            for(int i=0; i<n; i++){
                if(s.charAt(i) == '1'){
                    oneOnleft[i] = Math.min(n, prev+1);
                }else{
                    oneOnleft[i] = 0;
                }
                prev = oneOnleft[i];
            }
            
            prev = oneOnleft[n-1];
            for(int i=0; i<n; i++){
                if(s.charAt(i) == '1'){
                    oneOnleft[i] = Math.min(n, prev+1);
                }else{
                    oneOnleft[i] = 0;
                }
                prev = oneOnleft[i];
            }

            prev = 0;
            for(int i=n-1; i>=0; i--){
                if(s.charAt(i) == '1'){
                    oneOnright[i] = Math.min(n, prev+1);
                }else{
                    oneOnright[i] = 0;
                }
                prev = oneOnright[i];
            }
            prev = oneOnright[0];
            for(int i=n-1; i>=0; i--){
                if(s.charAt(i) == '1'){
                    oneOnright[i] = Math.min(n, prev+1);
                }else{
                    oneOnright[i] = 0;
                }
                prev = oneOnright[i];
            }

            long res = 0;
            for(int i=0; i<n; i++){
                res = Math.max(res, oneOnleft[i]*1l*oneOnright[i]);
            }

            System.out.println(res);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 0
// 1
// 101
// 011110
// 101010
// OutputCopy
// 0
// 1
// 2
// 6
// 1