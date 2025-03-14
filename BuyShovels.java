import java.util.*;

public class BuyShovels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int start = 1, end = n <= k ? n : k;
            int res = 1;
            while (start <= end) {
                int mid = (end - start) / 2 + start;
                if (n % mid == 0)
                    res = mid;
                int q = (int) Math.floor((n * 1.0) / mid);
                if (n / q <= end) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            System.out.println(n / res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 8 7
// 8 1
// 6 10
// 999999733 999999732
// 999999733 999999733
// OutputCopy
// 2
// 8
// 1
// 999999733
// 1

// unsolved.