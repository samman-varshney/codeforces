package Rating900;
import java.util.Scanner;
public class MakeItIncreasing {
    public static int helper(int[] arr){
        int n = arr.length;
        int res = 0;
        for(int i=n-2; i>=0; i--){
            if(arr[i+1] == 0)return -1;
            int pow = 0;
            if(arr[i+1] <= arr[i]){
                pow = (int)Math.floor(1 + Math.log((arr[i]*1.0)/arr[i+1])/Math.log(2));
                
                arr[i]  = (int)(arr[i]/Math.pow(2, pow));
            }
            // System.out.println(pow+" "+arr[i]);
            if(i!=0 && arr[i]==0)
                    return -1;
            res+=pow;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            System.out.println(helper(arr));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 7
// 3
// 3 6 5
// 4
// 5 3 2 1
// 5
// 1 2 3 4 5
// 1
// 1000000000
// 4
// 2 8 7 5
// 5
// 8 26 5 21 10
// 2
// 5 14
// OutputCopy
// 2
// -1
// 0
// 0
// 4
// 11
// 0
