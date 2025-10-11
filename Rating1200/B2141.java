package Rating1200;
import java.util.*;

public class B2141{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums1 = new int[n];
            for(int i=0; i<n; i++){
                nums1[i] = sc.nextInt();
            }
            int[] nums2 = new int[m];
            for(int i=0; i<m; i++){
               nums2[i] = sc.nextInt();
            }

            System.out.println(helper(n, m, nums1, nums2));
        }
        sc.close();
    }
    public static int helper(int n, int m, int[] nums1, int[] nums2){
        int[] freq = new int[101];
        for(int i=0; i<n; i++){
           freq[nums1[i]]++;
        }
        int duplicates = 0;
        for(int i=0; i<m; i++){
            if(freq[nums2[i]] != 0)
                duplicates++;
        }

        int alice = n - duplicates;
        int bob = m - duplicates;

        return alice <= bob ? alice*2 + 1: (bob+1)*2;
    }
}

// Example
// InputCopy
// 3
// 2 3
// 1 2
// 2 3 5
// 1 1
// 5
// 5
// 4 2
// 1 3 4 7
// 4 6
// OutputCopy
// 3
// 1
// 4