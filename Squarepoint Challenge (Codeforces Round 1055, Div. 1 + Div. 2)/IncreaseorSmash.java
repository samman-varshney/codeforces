
import java.util.*;

public class IncreaseorSmash{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] freq = new int[101];
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                freq[num] = 1;
            }
            int unique = 0;
            for(int x: freq){
                unique += x;
            }
            System.out.println(unique+(unique-1));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 3
// 1 1 3
// 1
// 100
// 9
// 9 9 3 2 4 4 8 5 3
// OutputCopy
// 3
// 1
// 11