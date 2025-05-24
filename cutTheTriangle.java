import java.util.*;

public class cutTheTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            sc.nextLine();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            if ((x1 == x2 || x2 == x3 || x3 == x1) && (y1 == y2 || y2 == y3 || y3 == y1))
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        sc.close();
    }
}
// Example
// InputCopy
// 4

// 4 7
// 6 8
// 3 5

// 4 5
// 4 7
// 6 8

// 5 8
// 1 8
// 2 5

// 3 6
// 6 6
// 6 3
// OutputCopy
// YES
// YES
// YES
// NO