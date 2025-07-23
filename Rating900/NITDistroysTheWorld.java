package Rating900;
import java.util.Scanner;
public class NITDistroysTheWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int i = 0;
            int res = 0;
            while(i<arr.length){
                int j = i;
                while(j<arr.length && arr[j] == 0)j++;
                int k = j;
                while(k<arr.length && arr[k]!=0)k++;
                if(k!=j)res++;
                i=k;
            }
            System.out.println(res<=1?res:2);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 4
// 0 0 0 0
// 5
// 0 1 2 3 4
// 7
// 0 2 3 0 1 2 0
// 1
// 1000000000
// OutputCopy
// 0
// 1
// 2
// 1