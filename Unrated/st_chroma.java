package Unrated;
import java.util.*;
public class st_chroma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int k = 0;
            for(int i=0; i<n-1; i++){
                if(k==x)
                    k++;
                System.out.print(k+" ");
                k++;
            }
            System.out.println(Math.min(k, x));

        }
        sc.close();
    }
}

// Example
// InputCopy
// 7
// 4 2
// 4 0
// 5 0
// 1 1
// 3 3
// 1 0
// 4 3
// OutputCopy
// 1 0 3 2
// 2 3 1 0
// 3 2 4 1 0
// 0
// 0 2 1
// 0
// 1 2 0 3