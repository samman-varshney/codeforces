package Rating1100;

import java.util.Scanner;
public class Coprime {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[1001];
            for(int i=0; i<n; i++){
                arr[sc.nextInt()] = i+1;
            }
            int res = arr[1] == 0?-1:Math.max(2*arr[1], arr[1]+n);
            for(int i=2; i<1001; i++){
                if(arr[i] == 0){
                    continue;
                }
                for(int j=i+1; j<1001; j++){
                    if(arr[j] == 0)continue;
                    if(i%j !=0 && j%i != 0 && gcd(i, j) == 1){
                        res = Math.max(res, arr[i]+arr[j]);
                    }
                }
            }
            System.out.println(res);

        }
        sc.close();
    }
}


// Example
// InputCopy
// 6
// 3
// 3 2 1
// 7
// 1 3 5 2 4 7 7
// 5
// 1 2 3 4 5
// 3
// 2 2 4
// 6
// 5 4 3 15 12 16
// 5
// 1 2 2 3 6
// OutputCopy
// 6
// 12
// 9
// -1
// 10
// 7