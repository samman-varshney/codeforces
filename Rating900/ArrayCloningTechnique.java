package Rating900;
import java.util.*;
public class ArrayCloningTechnique{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            int max = Integer.MIN_VALUE;
            for(int val : map.values())
                max = Math.max(max, val);

            int noc = (int)Math.ceil(Math.log((n*1.0)/max)/Math.log(2));
            System.out.println(noc + (n- max));

        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 1
// 1789
// 6
// 0 1 3 3 7 0
// 2
// -1000000000 1000000000
// 4
// 4 3 2 1
// 5
// 2 5 7 6 3
// 7
// 1 1 1 1 1 1 1
// OutputCopy
// 0
// 6
// 2
// 5
// 7
// 0