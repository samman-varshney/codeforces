package Rating1200;
import java.util.*;

public class C2126{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] hts = new int[n];
            for(int i=0; i<n; i++){
                hts[i] = sc.nextInt();
            }
            System.out.println(helper(n, k-1, hts));
        }
        sc.close();
    }
    public static String helper(int n, int idx, int[] hts){
        int[][] nums = new int[n][2];
        for(int i=0; i<n; i++){
            nums[i][0] = i;
            nums[i][1] = hts[i];
        }
        Arrays.sort(nums, (a, b)->(a[1]-b[1]));
        int i = 0;
        while(idx != nums[i][0])i++;
        int level = 1;
        for( ; i<n-1; i++){
            int time = nums[i+1][1] - nums[i][1];
            level += time;
            if(level-1 > nums[i][1])
                return "NO";
        }
        return "YES";
    }
}


// Example
// InputCopy
// 5
// 5 3
// 3 2 1 4 5
// 3 1
// 1 3 4
// 4 4
// 4 4 4 2
// 6 2
// 2 3 6 9 1 2
// 4 2
// 1 2 5 6
// OutputCopy
// YES
// NO
// YES
// YES
// NO