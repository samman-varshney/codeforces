package Rating1100;

import java.util.Scanner;
public class BinaryTypewriter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            String str = sc.next();
            int res = 0;
            int count = 0;
            char prev = '0';
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if(prev!= c){
                    count++;
                    res++;
                    prev = c;
                }
                res++;
            }
            if(count >= 3){
                System.out.println(res-2);;
            }else if(count >= 2){
                System.out.println(res - 1);;
            }else{
                System.out.println(res);
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 3
// 000
// 3
// 111
// 3
// 011
// 3
// 100
// 5
// 10101
// 19
// 1101010010011011100
// OutputCopy
// 3
// 4
// 4
// 4
// 8
// 29
