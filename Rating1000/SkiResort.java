package Rating1000;
import java.util.Scanner;
public class SkiResort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase--> 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();
            int count = 0;
            long res = 0;
            for(int i=0; i<n; i++){
                int temp = sc.nextInt();
                if(temp <= q){
                    count++;
                }else{
                    if(count >= k)
                        res += (count-k+1)*(count+1) -((count*(count+1))/2 - (k*(k-1))/2);
                    
                    count = 0;
                }
            }
            if(count >= k)
                res+= (count-k+1l)*(count+1l) -((count*(count+1l))/2 - (k*(k-1l))/2);
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 7
// 3 1 15
// -5 0 -10
// 5 3 -33
// 8 12 9 0 5
// 4 3 12
// 12 12 10 15
// 4 1 -5
// 0 -1 2 5
// 5 5 0
// 3 -1 4 -5 -3
// 1 1 5
// 5
// 6 1 3
// 0 3 -2 5 -4 -4
// OutputCopy
// 6
// 0
// 1
// 0
// 0
// 1
// 9