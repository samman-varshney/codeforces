package Rating1000;
import java.util.Scanner;
public class OlyaandGamewithArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-->0){
            int n = sc.nextInt();
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            long res = 0;
            for(int i=0; i<n; i++){
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                int m = sc.nextInt();
                for(int j=0; j<m; j++){
                    int num = sc.nextInt();
                    if(a > num){
                        b = a;
                        a = num;
                    }else if(b > num){
                        b = num;
                    }
                }
                min1 = Math.min(min1, a);
                min2 = Math.min(min2, b);
                res+=b;
            }
            System.out.println(res-min2+min1);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 3
// 2
// 2
// 1 2
// 2
// 4 3
// 1
// 3
// 100 1 6
// 3
// 4
// 1001 7 1007 5
// 3
// 8 11 6
// 2
// 2 9
// OutputCopy
// 5
// 1
// 19