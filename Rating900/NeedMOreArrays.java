package Rating900;
import java.util.Scanner;
public class NeedMOreArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            
            int i=n-1; 
            int res = 0;
            while(i>0){
                int j = i-1;
                while(j>=0 && arr[i] - arr[j] <= 1)
                    j--;
                res++;
                i = j;
            }
            if(i == 0)
                res++;
            System.out.println(res);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 6
// 1 2 3 4 5 6
// 3
// 1 2 3
// 4
// 1 2 2 4
// 1
// 2
// 3
// 1 4 8
// 2
// 1 1
// OutputCopy
// 3
// 2
// 2
// 1
// 3
// 1