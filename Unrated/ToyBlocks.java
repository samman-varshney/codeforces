package Unrated;
import java.util.*;

public class ToyBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            long n = sc.nextLong();
            long sum = 0;
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long num = sc.nextLong();
                max = Math.max(max, num);
                sum += num;
            }
            long maxSum = Math.max(max * (n - 1l), sum);
            long k = (long) Math.ceil(maxSum / (n - 1.0));

            long res = k * (n - 1) - sum;
            System.out.println(res);
        }
        sc.close();
    }

}