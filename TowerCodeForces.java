import java.util.*;

public class TowerCodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            int[] towers = Arrays.copyOfRange(arr, m, n);

            int minOps = Integer.MAX_VALUE;

            for (int target : towers) {
                int ops = 0;
                for (int h : towers) {

                    while (h > target) {
                        if (h / 2 >= target) {
                            h /= 2;
                            ops++;
                        } else {
                            ops += (h - target);
                            break;
                        }
                    }
                    while (h < target) {
                        h++;
                        ops++;
                    }
                }
                minOps = Math.min(minOps, ops);
            }

            System.out.println(minOps);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 2 0
// 2 6
// 5 0
// 1 2 3 4 5
// 5 3
// 1 2 3 4 5
// OutputCopy
// 2
// 4
// 1