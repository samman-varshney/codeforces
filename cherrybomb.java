import java.util.*;
public class cherrybomb {
    static Scanner sc = new Scanner(System.in);
    public static int helper(){
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
            if(a[i] < min){
                min = a[i];
            }
            if(a[i] > max){
                max = a[i];
            }
        }
        if(max > k){
            return 0;
            
        }
        boolean allneg = true;
        boolean invalid = false;
        
        int prev = -1;
        for(int i=0; i<n; i++){
            int b = sc.nextInt();
            if(b >= 0){
                allneg = false;
                if(prev  != -1 && prev != a[i]+b){
                    invalid = true;
                    break;
                }else{
                    prev = a[i]+b;
                }
            }
        }

        if(invalid){
            return 0;
        }else if(!allneg){
            return 1;
        }else{
            return k-(max-min)+1;
        }
    }
    public static void main(String[] args) {
        
        int tcase = sc.nextInt();
        while(tcase-- >0){
            System.out.println(helper());
        }
        sc.close();

    }
}


// Example
// InputCopy
// 7
// 3 10
// 1 3 2
// -1 -1 1
// 5 1
// 0 1 0 0 1
// -1 0 1 0 -1
// 5 1
// 0 1 0 0 1
// -1 1 -1 1 -1
// 5 10
// 1 3 2 5 4
// -1 -1 -1 -1 -1
// 5 4
// 1 3 2 1 3
// 1 -1 -1 1 -1
// 5 4
// 1 3 2 1 3
// 2 -1 -1 2 0
// 5 5
// 5 0 5 4 3
// 5 -1 -1 -1 -1
// OutputCopy
// 1
// 0
// 0
// 7
// 0
// 1
// 0