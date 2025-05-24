package Rating900;
import java.util.Scanner;
public class JellyfishAndUndertale{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            long[] tools = new long[n];
            for(int i=0; i<n; i++){
                tools[i] = sc.nextLong();
            }
            long res = b;
            for(long tool : tools){
                if(tool >= a)
                    res+=a-1;
                else
                    res+=tool;
            }
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 2
// 5 3 3
// 1 1 7
// 7 1 5
// 1 2 5 6 8
// OutputCopy
// 9
// 21