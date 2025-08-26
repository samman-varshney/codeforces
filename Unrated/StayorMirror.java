package Unrated;

import java.util.Scanner;
public class StayorMirror {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            int res = 0;
            for(int i=0; i<n; i++){
                int GOL = 0;
                int AGOL = 0;
                for(int j=0; j<i; j++){
                    if(arr[j] > arr[i]){
                        AGOL++;
                    }
                    int trueValue = arr[j] > n? 2*n - arr[j]:arr[j];
                    if(trueValue > arr[i])
                        GOL++;
                }
                int ROL = 0;
                for(int j=i+1; j<n; j++){
                    if(arr[j] > arr[i])
                        ROL++;
                }
                if(GOL <= ROL){
                    res += AGOL;
                }else if(GOL > ROL){
                    res += AGOL - GOL;
                    arr[i] = 2*n - arr[i];
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}
// Example
// InputCopy
// 5
// 2
// 2 1
// 3
// 2 1 3
// 4
// 4 3 2 1
// 5
// 2 3 1 5 4
// 6
// 2 3 4 1 5 6
// OutputCopy
// 0
// 1
// 0
// 2
// 2