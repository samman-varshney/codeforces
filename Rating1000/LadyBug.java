package Rating1000;

import java.util.Scanner;
public class LadyBug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
         while (tcase-- >0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            int evenidx = 0, oddidx =0;
            for(int i=0; i<n; i++){
                if(a.charAt(i) == '1'){
                    if(i%2 == 0){
                        evenidx++;
                    }else{
                        oddidx++;
                    }
                }
                if(b.charAt(i) == '0'){
                    if(i%2 == 0){
                        oddidx--;
                    }else{
                        evenidx--;
                    }
                }
            }

            if(evenidx <=0 && oddidx <= 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 3
// 000
// 000
// 6
// 010001
// 010111
// 5
// 10000
// 01010
// 2
// 11
// 00
// OutputCopy
// YES
// YES
// NO
// YES