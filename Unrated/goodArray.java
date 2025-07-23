package Unrated;
import java.util.*;

public class goodArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();

            long originalsum = 0;
            long goodsum = 0;
            int i = n;
            while (i-- > 0) {
                int temp = sc.nextInt();
                originalsum += temp;
                if (temp > 1)
                    goodsum += 1;
                else
                    goodsum += 2;
            }

            if (n != 1 && goodsum <= originalsum)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
        sc.close();
    }
}
// Example
// InputCopy
// 6
// 3
// 6 1 2
// 2
// 1 1
// 4
// 3 1 2 4
// 1
// 17
// 5
// 1 2 1 1 1
// 3
// 618343152 819343431 1000000000
// OutputCopy
// YES
// NO
// YES
// NO
// NO
// YES