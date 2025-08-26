package Rating1200;

import java.util.Scanner;
public class ContrastValue {
    static int solve(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 1;
        }
        int deno = Math.abs(arr[0] - arr[1]);
        int slope = (arr[0]- arr[1]) / ( deno == 0 ? 1 : deno);
        int count = 1;
        for (int i = 2; i < n; i++) {
            deno = Math.abs(arr[i - 1] - arr[i]);
            int currentSlope = (arr[i - 1] - arr[i]) / (deno == 0 ? 1 : deno);
            if (Math.abs(currentSlope - slope) > 1) {
                count++;
                slope = currentSlope;
            }else if (currentSlope != 0) {
                slope = currentSlope;
            }
        }
        return slope != 0 ? count + 1 : count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(arr));
        }
        sc.close();
    }
}


// Example
// InputCopy
// 4
// 5
// 1 3 3 3 7
// 2
// 4 2
// 4
// 1 1 1 1
// 7
// 5 4 2 1 0 0 4
// OutputCopy
// 2
// 2
// 1
// 3

// 3
// 0 0 1
// 2