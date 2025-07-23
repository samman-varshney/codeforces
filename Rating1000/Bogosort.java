package Rating1000;
import java.util.Scanner;
import java.util.Arrays;
public class Bogosort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            for(int i = n-1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 1
// 7
// 4
// 1 1 3 5
// 6
// 3 2 1 5 6 4
// OutputCopy
// 7
// 1 5 1 3
// 2 4 6 1 3 5
