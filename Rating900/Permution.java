package Rating900;
import java.util.Scanner;
import java.util.ArrayList;
public class Permution {
    public static int gcd(int a, int b){
        if(a > b){
            return gcd(b, a);
        }
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
      
            
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                int swap = Math.abs(num - (i+1));
                list.add(swap);
            }
            System.out.println(list.toString());

            int res = list.get(0);
            for(int i=1; i<list.size(); i++){
                res = gcd(res, list.get(i));
            }
            System.out.println(res);
        }
        sc.close();
    }  
}


// Example
// InputCopy
// 7
// 3
// 3 1 2
// 4
// 3 4 1 2
// 7
// 4 2 6 7 5 3 1
// 9
// 1 6 7 4 9 2 3 8 5
// 6
// 1 5 3 4 2 6
// 10
// 3 10 5 2 9 6 7 8 1 4
// 11
// 1 11 6 4 8 3 7 5 9 10 2
// OutputCopy
// 1
// 2
// 3
// 4
// 3
// 2
// 3