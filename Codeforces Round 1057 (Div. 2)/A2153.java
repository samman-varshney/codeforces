import java.util.*;

public class A2153{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                set.add(num);
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}