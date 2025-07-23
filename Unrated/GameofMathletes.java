package Unrated;
import java.util.*;

public class GameofMathletes {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Size of the array
            int k = sc.nextInt(); // Target sum
            int arr[] = new int[n];

            // Reading the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Sorting the array
            Arrays.sort(arr);

            int i = 0; // Left pointer
            int j = n - 1; // Right pointer
            int count = 0; // Count of pairs

            // Two-pointer approach
            while (i < j) {
                int sum = arr[i] + arr[j];

                if (sum == k) {
                    count++;
                    i++; // Move the left pointer
                    j--; // Move the right pointer
                } else if (sum < k) {
                    i++; // Increase the left pointer
                } else {
                    j--; // Decrease the right pointer
                }
            }

            System.out.println(count);
        }
        sc.close();
    }

}
// InputCopy
// 4
// 4 4
// 1 2 3 2
// 8 15
// 1 2 3 4 5 6 7 8
// 6 1
// 1 1 1 1 1 1
// 16 9
// 3 1 4 1 5 9 2 6 5 3 5 8 9 7 9 3
// OutputCopy
// 2
// 1
// 0
// 4