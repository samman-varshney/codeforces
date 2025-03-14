import java.util.*;

public class lcs {
    public static int helper(String s1, String s2, int i, int j, int count) {
        // Base case: when either string is empty
        if (i == 0 || j == 0) {
            return count;
        }

        int currentCount = count;

        // If characters match, recursively find the length of the substring
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            currentCount = helper(s1, s2, i - 1, j - 1, count + 1);
        }

        // Compare with the possibilities by either reducing i or j
        int option1 = helper(s1, s2, i - 1, j, 0); // reset count when moving left
        int option2 = helper(s1, s2, i, j - 1, 0); // reset count when moving up

        // Return the maximum of all possibilities
        return Math.max(currentCount, Math.max(option1, option2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(helper(s1, s2, s1.length(), s2.length(), 0));
        sc.close();
    }

}
// yxxzzxxxx
// yzyzxxyxxz