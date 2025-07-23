package Rating900;
import java.util.Scanner;
public class OddGrasshopper{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            long init = sc.nextLong();
            long jump = sc.nextLong();

            if(jump%2 == 1){
                int mod = (int)(jump/2)%2;
                if(mod == 0)
                    System.out.println(init + (init%2 == 0?-jump:jump));
                else
                    System.out.println(init + (init%2 == 0?jump+1:-jump-1));
            }else{
                int mod = (int)(jump/2)%2;
                if(mod == 0)
                    System.out.println(init);
                else
                    System.out.println(init + (init%2 == 0?1:-1));
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 9
// 0 1
// 0 2
// 10 10
// 10 99
// 177 13
// 10000000000 987654321
// -433494437 87178291199
// 1 0
// -1 1
// OutputCopy
// -1
// 1
// 11
// 110
// 190
// 9012345679
// -87611785637
// 1
// 0