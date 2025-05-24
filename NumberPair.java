
import java.util.*;

public class NumberPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            // int l = sc.nextInt();
            // int r = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            Arrays.sort(nums);
            int i = 0, j = n - 1;

            System.out.println(((j - i + 1) * (j - i)) / 2);

        }
        sc.close();
    }
}
