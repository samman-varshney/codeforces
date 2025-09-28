package Unrated;
import java.util.*;

public class MultipleConstruction{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int i=n-1; i>=1; i--){
                list.add(i);
            }
            // System.out.println(n+" "+list.join(" ")+" "+n+" "+list.reverse().join(" "));
        }
        sc.close();
    }
}   

// Example
// InputCopy
// 3
// 2
// 3
// 1
// OutputCopy
// 1 2 1 2
// 1 3 1 2 3 2
// 1 1