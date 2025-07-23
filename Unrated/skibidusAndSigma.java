package Unrated;
import java.util.*;

public class skibidusAndSigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt() * sc.nextInt();
            int sum = 0, prev = 0;
            while (n-- > 0) {
                int curr = sc.nextInt() + prev;
                sum += curr;
                prev = curr;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}

// wrong answer.