package Rating1000;
import java.util.Scanner;
public class RoofConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int msb = (int)Math.floor(Math.log(n-1)/Math.log(2));
            int insert = (int)Math.pow(2, msb);
            for(int i=1; i<n; i++){
                if(i == insert)
                    System.out.print(0+" "+i+" ");
                else{
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 2
// 3
// 5
// 10
// OutputCopy
// 0 1
// 2 0 1
// 3 2 1 0 4
// 4 6 3 2 0 8 9 1 7 5