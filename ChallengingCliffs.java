import java.io.*;
import java.util.*;

public class ChallengingCliffs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // For efficient output

        int tcase = Integer.parseInt(br.readLine().trim());

        while (tcase-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input[i]);
            }

            // Sort the array to identify the smallest difference
            Arrays.sort(nums);

            // Find the pair with the smallest difference
            int minDiff = Integer.MAX_VALUE;
            int minDiffIdx = 0;
            for (int i = 1; i < n; i++) {
                int diff = nums[i] - nums[i - 1];
                if (diff < minDiff) {
                    minDiff = diff;
                    minDiffIdx = i;
                }
            }

            // Build the result array by rotating the smallest difference pair
            for (int i = 0; i < n; i++) {
                if (i == minDiffIdx) {
                    sb.append(nums[i - 1]).append(" ").append(nums[i]).append(" ");
                    i++; // Skip the next index as it's part of the pair
                } else if (i != minDiffIdx - 1) {
                    sb.append(nums[i]).append(" ");
                }
            }
            sb.append("\n");
        }

        // Print the final result after all test cases
        System.out.print(sb);
    }
}
