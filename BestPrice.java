import java.util.*;

public class BestPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong(); // Convert k to long

            long[] lower = new long[n];
            for (int i = 0; i < n; i++) {
                lower[i] = sc.nextLong();
            }
            long[] upper = new long[n];
            for (int i = 0; i < n; i++) {
                upper[i] = sc.nextLong();
            }
            long maxEarn = Long.MIN_VALUE; // Use Long.MIN_VALUE

            for (int i = 0; i < n; i++) {
                long price = upper[i];
                long earning = 0;
                long limit = k;

                for (int j = 0; j < n; j++) {
                    if (price > lower[j] && price <= upper[j])
                        limit--;
                    if (limit >= 0) {
                        if (price <= upper[j])
                            earning += price;
                    } else {
                        earning = 0;
                        break;
                    }
                }
                maxEarn = Math.max(maxEarn, earning);

                price = lower[i];
                earning = 0;
                limit = k;

                for (int j = 0; j < n; j++) {
                    if (price > lower[j] && price <= upper[j])
                        limit--;
                    if (limit >= 0) {
                        if (price <= upper[j])
                            earning += price;
                    } else {
                        earning = 0;
                        break;
                    }
                }
                maxEarn = Math.max(maxEarn, earning);
            }
            System.out.println(maxEarn);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 2 0
// 2 1
// 3 4
// 1 1
// 2
// 5
// 3 3
// 1 5 2
// 3 6 4
// 4 3
// 2 3 2 8
// 3 7 3 9
// 3 1
// 2 9 5
// 12 14 9
// OutputCopy
// 2
// 5
// 9
// 14
// 15