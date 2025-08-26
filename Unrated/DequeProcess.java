package Unrated;

import java.util.Scanner;
public class DequeProcess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            int i=0, j=n-1;
            boolean small = true;
            while(i<=j){
                if(small){
                    if(arr[i] < arr[j]){
                        sb.append("L");
                        i++;
                    }else{
                        sb.append("R");
                        j--;
                    }
                }else{
                    if(arr[i] > arr[j]){
                        sb.append("L");
                        i++;
                    }else{
                        sb.append("R");
                        j--;
                    }
                }
                small = !small;
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 7
// 1 2 3 4 5 6 7
// 9
// 1 3 6 8 9 7 5 4 2
// 12
// 1 2 11 3 6 4 7 8 12 5 10 9
// 6
// 4 1 2 5 6 3
// 5
// 1 2 3 5 4
// 9
// 5 1 8 6 2 7 9 4 3
// OutputCopy
// RRRLLLL
// LLRRLLRRL
// LLLLLLLLLLLL
// LLLLLL
// LLLLL
// LLLLLLLLL
