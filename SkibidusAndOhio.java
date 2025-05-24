import java.util.*;

public class SkibidusAndOhio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            String s = sc.next();
            boolean canReduce = false;
            for (int i = 0; i < s.length() - 1; i++)
                if (s.charAt(i) == s.charAt(i + 1)) {
                    canReduce = true;
                    break;
                }

            System.out.println(canReduce ? 1 : s.length());
        }
        sc.close();
    }
}

// InputCopy
// 4
// baa
// skibidus
// cc
// ohio
// OutputCopy
// 1
// 8
// 1
// 4