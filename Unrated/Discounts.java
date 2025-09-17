package Unrated;
import java.util.*;

public class Discounts{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Integer[] prod = new Integer[n];
            int[] disc = new int[k];

            for(int i=0; i<n; i++){
                prod[i] = sc.nextInt();
            }
            for(int i=0; i<k; i++){
                disc[i] = sc.nextInt();
            }

            Arrays.sort(prod, Collections.reverseOrder());
            Arrays.sort(disc);

            int i=0;
            long res = 0;
            for(int x: disc){
                int idx = i+x-1;
                if( idx < n){
                    for(int j=i; j<idx; j++){
                        res += prod[j];
                    }
                    i = idx + 1;
                }else{
                    break;
                }
            }
            while( i < n){
                res += prod[i];
                i++;
            }
            System.out.println(res);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 5
// 5 3
// 18 3 7 2 9
// 3 1 1
// 6 1
// 1 2 6 3 3 4
// 5
// 2 3
// 1 1
// 2 2 2
// 1 1
// 10
// 1
// 5 3
// 99 99 999 999 123
// 2 1 4
// OutputCopy
// 10
// 17
// 1
// 0
// 1197