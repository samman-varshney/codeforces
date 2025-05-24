import java.util.*;

public class giftFromOrangotang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            int score = 0;
            int maxValue = a[n - 1];

            for (int i = 0; i < n; i++) {
                int minValue = a[i];
                score += maxValue - minValue;
            }

            System.out.println(score);
        }
        sc.close();
    }
}
