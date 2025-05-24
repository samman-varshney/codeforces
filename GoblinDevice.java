import java.util.Scanner;

public class GoblinDevice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            long hiphen = 0, underScore = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '_') {
                    underScore++;
                } else if (s.charAt(i) == '-') {
                    hiphen++;
                }
            }

            System.out.println((hiphen / 2) * ((hiphen + 1) / 2) * underScore);

        }
        sc.close();
    }
}
// Example
// InputCopy
// 8
// 3
// --_
// 5
// __-__
// 9
// --__-_---
// 4
// _--_
// 10
// _-_-_-_-_-
// 7
// _------
// 1
// -
// 2
// _-
// OutputCopy
// 1
// 0
// 27
// 2
// 30
// 9
// 0
// 0