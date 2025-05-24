import java.util.*;

public class SameDifferences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int nums = sc.nextInt() - i;
                map.put(nums, map.getOrDefault(nums, 0) + 1);
            }

            long count = 0;
            for (int num : map.values()) {

                count += (num * (num - 1l)) / 2l;
            }
            System.out.println(count);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 6
// 3 5 1 4 6 6
// 3
// 1 2 3
// 4
// 1 3 3 4
// 6
// 1 6 3 4 5 6
// OutputCopy
// 1
// 3
// 3
// 10