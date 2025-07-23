package Unrated;

import java.util.Scanner;
public class PileShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            long operations = 0;
            while(n-- >0){
                int originalZeros = sc.nextInt();
                int originalOnes = sc.nextInt();
                int targetZeros = sc.nextInt();
                int targetOnes = sc.nextInt();

                if(originalZeros > targetZeros){
                    operations += originalZeros - targetZeros;
                }
                if(originalOnes > targetOnes){
                    if(targetZeros==0 || originalZeros==0){
                        operations += originalOnes - targetOnes;
                    }else{
                        operations +=  originalOnes - targetOnes +  Math.min(targetZeros, originalZeros);
                    }
                }
            }
            System.out.println(operations);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 2
// 1 3 1 2
// 1 1 1 2
// 3
// 2 0 2 2
// 0 1 1 0
// 1 1 0 0
// 3
// 1 2 1 2
// 3 4 3 4
// 0 0 0 0
// OutputCopy
// 2
// 3
// 0
