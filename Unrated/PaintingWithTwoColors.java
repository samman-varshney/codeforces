package Unrated;
import java.util.Scanner;
public class PaintingWithTwoColors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) helper(sc);
    }

    private static void helper(Scanner sc) {
        long n = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        if((n-b) % 2 != 0){
            System.out.println("NO");
            return;
        }
        long l = (n-b)/2;
        if(a <= b){
            System.out.println("YES");
            return;
        }
        if((n-a) % 2 == 0){
            System.out.println("YES");
            return;
        }
        if(a > b && (a-b) % 2 == 0){
            long l1 = (a-b)/2;
            if(l >= 1 && l1 <= l ){
                System.out.println("YES");
                return;
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println("NO");
    }
}

// Example
// InputCopy
// 7
// 5 3 1
// 4 1 2
// 7 7 4
// 8 3 7
// 1 1 1
// 1000000000 1000000000 1000000000
// 3 2 1
// OutputCopy
// YES
// YES
// NO
// NO
// YES
// YES
// NO