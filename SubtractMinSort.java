import java.util.*;

public class SubtractMinSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt(); // Number of test cases

        while (tcase-- > 0) {
            int n = sc.nextInt(); // Size of the array
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            boolean isNonDecreasing = true;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    isNonDecreasing = false;
                    break;
                }
                nums[i + 1] -= nums[i];
            }
            System.out.println(isNonDecreasing ? "YES" : "NO");
        }
        sc.close();
    }
}
