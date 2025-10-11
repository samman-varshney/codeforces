package Rating1200;
import java.util.*;

public class A2138{
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            long k = sc.nextLong();
            long x = sc.nextLong();
            long chocola = x;
            long vanilla = 1l<<(k+1) - x;
            List<Integer> res = new ArrayList<>();
            while(chocola != 1l<<k){
                if(chocola > 0 && chocola < 1l<<k){
                    res.add(1);
                    vanilla = vanilla - chocola;
                    chocola = chocola*2;
                }else{
                    res.add(2);
                    chocola = chocola - vanilla;
                    vanilla = 2*vanilla;
                }
            }
            System.out.println(res.size());
            for(int i=res.size()-1; i>=0; i--)
                System.out.print(res.get(i)+" ");
            System.out.println();
        }
        sc.close();
    }

}

// Example
// InputCopy
// 4
// 2 3
// 2 4
// 3 7
// 2 5
// OutputCopy
// 2
// 2 1 
// 0

// 3
// 2 2 1 
// 2
// 1 2 