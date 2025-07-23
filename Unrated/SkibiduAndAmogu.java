package Unrated;
import java.util.*;

public class SkibiduAndAmogu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            String s = sc.next();
            int n = s.length();
            System.out.println(s.substring(0, n - 2) + "i");
        }
        sc.close();
    }
}

// Example
// InputCopy
// 9
// us
// sus
// fungus
// cactus
// sussus
// amogus
// chungus
// ntarsus
// skibidus
// OutputCopy
// i
// si
// fungi
// cacti
// sussi
// amogi
// chungi
// ntarsi
// skibidi
