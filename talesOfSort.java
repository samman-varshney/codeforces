import java.util.*;

public class talesOfSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int maxPrefix = 0; // This tracks the maximum of the prefix
            int prev = sc.nextInt();

            while (n-- > 1) {
                int curr = sc.nextInt();
                if (prev > curr) { // Check where the order breaks
                    maxPrefix = Math.max(maxPrefix, prev); // Update max prefix value
                }
                prev = curr; // Move to the next pair of elements
            }
            System.out.println(maxPrefix); // Output the result for the current test case
        }
        sc.close();
    }
}

// Example
// InputCopy
// 7
// 3
// 1 2 3
// 5
// 2 1 2 1 2
// 4
// 3 1 5 4
// 2
// 7 7
// 5
// 4 1 3 2 5
// 5
// 2 3 1 4 5
// 3
// 1000000000 1 2
// OutputCopy
// 0
// 2
// 5
// 0
// 4
// 3
// 1000000000