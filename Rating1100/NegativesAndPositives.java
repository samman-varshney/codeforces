package Rating1100;

import java.util.Scanner;
public class NegativesAndPositives {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            Long n = sc.nextLong();
            Long absoluteMinValue = Long.MAX_VALUE;
            Long parityOfNegative = 0l;
            Long absoluteSum = 0l;

            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                absoluteSum += Math.abs(num);
                if(num < 0){
                    parityOfNegative++;
                }
                absoluteMinValue = Math.min( absoluteMinValue, Math.abs(num));
            }

            if(parityOfNegative%2 == 1){
                absoluteSum -= 2*absoluteMinValue;
            }
            System.out.println(absoluteSum);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 3
// -1 -1 -1
// 5
// 1 5 -5 0 2
// 3
// 1 2 3
// 6
// -1 10 9 8 7 6
// 2
// -1 -1
// OutputCopy
// 1
// 13
// 6
// 39
// 2