package Rating1000;
import java.util.Scanner;
public class RedVersusBlue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int r = sc.nextInt();
            int b = sc.nextInt();
            int min,max;
            char maxChar, minChar;
            if(r>b){
                max = r;
                min = b;
                maxChar = 'R';
                minChar = 'B';
            }else{
                max = b;
                min = r;
                maxChar = 'B';
                minChar = 'R';
            }
            int minConsecutiveSeq = (max+min)/(min+1);
            
            StringBuilder res = new StringBuilder();
            for(int i=0; i<min; i++){
                for(int j=0; j<minConsecutiveSeq; j++){
                    res.append(maxChar);
                }
                res.append(minChar);
            }
            int left = n-res.length();
            for(int i=0; i<left; i++){
                res.append(maxChar);
            }
            System.out.println(res.toString());
        }
        sc.close();
    }
}
// Examples
// InputCopy
// 3
// 7 4 3
// 6 5 1
// 19 13 6
// OutputCopy
// RBRBRBR
// RRRBRR
// RRBRRBRRBRRBRRBRRBR
// InputCopy
// 6
// 3 2 1
// 10 6 4
// 11 6 5
// 10 9 1
// 10 8 2
// 11 9 2
// OutputCopy
// RBR
// RRBRBRBRBR
// RBRBRBRBRBR
// RRRRRBRRRR
// RRRBRRRBRR
// RRRBRRRBRRR