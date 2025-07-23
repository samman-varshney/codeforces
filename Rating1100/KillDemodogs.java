package Rating1100;

import java.math.BigInteger;
import java.util.Scanner;

public class KillDemodogs {
    private static final BigInteger MOD = BigInteger.valueOf(1_000_000_007);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger SIX = BigInteger.valueOf(6);
    private static final BigInteger TWO_THOUSAND_TWENTY_TWO = BigInteger.valueOf(2022);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            // read n as a BigInteger
            BigInteger n = new BigInteger(sc.next());

            // term1 = n(n+1)(2n+1) / 6
            BigInteger term1 = n
                    .multiply(n.add(BigInteger.ONE))
                    .multiply(n.multiply(TWO).add(BigInteger.ONE))
                    .divide(SIX);

            // term2 = n(n-1)(2n-1) / 6
            BigInteger term2 = n
                    .multiply(n.subtract(BigInteger.ONE))
                    .multiply(n.multiply(TWO).subtract(BigInteger.ONE))
                    .divide(SIX);

            // term3 = n(n-1) / 2
            BigInteger term3 = n
                    .multiply(n.subtract(BigInteger.ONE))
                    .divide(TWO);

            // sum = term1 + term2 + term3  (all calculations before applying mod)
            BigInteger sum = term1.add(term2).add(term3).mod(MOD);

            // final answer = 2022 * sum (mod MOD)
            BigInteger answer = TWO_THOUSAND_TWENTY_TWO.multiply(sum).mod(MOD);

            System.out.println(answer);
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 2
// 3
// 50
// 1000000000
// OutputCopy
// 14154
// 44484
// 171010650
// 999589541