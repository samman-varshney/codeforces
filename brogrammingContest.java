import java.util.*;

public class brogrammingContest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int count = 0;
            boolean startWithZero = s.charAt(0) == '0';

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1))
                    count++;
            }

            System.out.println(startWithZero ? count : count + 1);

        }
        sc.close();
    }
}
