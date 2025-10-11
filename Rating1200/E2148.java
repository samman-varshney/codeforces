package Rating1200;
import java.util.*;

public class E2148{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            System.out.println(helper(n, k, arr));
        }
        sc.close();
    }
    public static long helper(int n, int k, int[] nums){
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i=0; i<n; i++){
           map.put(nums[i], map.getOrDefault(nums[i], 0l)+1);
        }
        for(long freq: map.values()){
            if(freq%k != 0){
                return 0;
            }
        }
        HashMap<Integer, Long> freq = new HashMap<>();
        int j=0;
        long res = 0;
        for(int i=0; i<n; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0l)+1);
            while(j<=i && freq.get(nums[i]) > map.get(nums[i])/k){
                freq.put(nums[j], freq.get(nums[j])-1);
                if(freq.get(nums[j]) == 0){
                    freq.remove(nums[j]);
                }
                j++;
            }
            res += i-j+1;
        }
        return res;
    }

}

// Example
// InputCopy
// 4
// 3 2
// 1 1 1
// 4 2
// 1 2 1 2
// 8 2
// 3 3 3 3 2 2 2 2
// 6 3
// 1 1 1 1 1 1
// OutputCopy
// 0
// 7
// 18
// 11
