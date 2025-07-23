package Unrated;
import java.util.*;

public class ClockWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            boolean finite = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 2 * Math.max(i, n - i - 1))
                    finite = true;
                if (finite)
                    break;
            }
            System.out.println(finite ? "NO" : "YES");
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 2
// 4 10
// 2
// 2 2
// 3
// 4 10 5
// 3
// 5 3 5
// 5
// 12 13 25 17 30
// OutputCopy
// YES
// NO
// NO
// YES
// YES