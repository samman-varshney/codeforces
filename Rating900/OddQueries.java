package Rating900;
import java.util.*;
public class OddQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            
            long prefix[] = new long[n+1];
            for(int i=1; i<=n; i++){
                prefix[i] = prefix[i-1]+sc.nextInt();
            }
            while(q-- >0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                long newSum = prefix[n] - prefix[r] +prefix[l-1] + k*(r-l+1l);
                if(newSum%2 == 1)
                    System.out.println("Yes");
                else    
                    System.out.println("No");
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 2
// 5 5
// 2 2 1 3 2
// 2 3 3
// 2 3 4
// 1 5 5
// 1 4 9
// 2 4 3
// 10 5
// 1 1 1 1 1 1 1 1 1 1
// 3 8 13
// 2 5 10
// 3 8 10
// 1 10 2
// 1 9 100
// OutputCopy
// YES
// YES
// YES
// NO
// YES
// NO
// NO
// NO
// NO
// YES