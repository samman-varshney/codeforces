package Unrated;
import java.util.*;

public class peaseantPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            int count = 0;
            for (int i = 0; i < n; i++) {
                int j = (int) Math.ceil(((2 * (i + 1)) / nums[i]) + 0.01);
                while (true) {
                    int prod = nums[i] * j;
                    int idx = prod - i - 2;
                    if (idx >= n)
                        break;
                    if (nums[idx] == j)
                        count++;
                    j++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 2
// 3 1
// 3
// 6 1 5
// 5
// 3 1 5 9 2
// OutputCopy
// 1
// 1
// 3