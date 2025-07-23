package Rating1100;

import java.util.Scanner;
public class DifferenceOfGCD {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            boolean flag = true;
            int[] arr = new int[n];
            for(int i=1; i<=n; i++){
                int rem = l%i;
                int ele = l + (rem!=0?i-rem: rem);
                if( r < ele){
                    flag = false;
                    break;
                }
                arr[i-1] = ele;
            }
            if(!flag){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                for(int x: arr)
                    System.out.print(x+" ");
                System.out.println();
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 5 1 5
// 9 1000 2000
// 10 30 35
// 1 1000000000 1000000000
// OutputCopy
// YES
// 1 2 3 4 5
// YES
// 1145 1926 1440 1220 1230 1350 1001 1000 1233
// NO
// YES
// 1000000000
