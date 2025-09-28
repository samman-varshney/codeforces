package Unrated;
import java.util.*;

public class ShortestIncreasingPath{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(y == 0){
                System.out.println(1);
            }else if(x < y){
                System.out.println(2);  
            }else if(y > 1 && y < x-1){
                System.out.println(3);
            }else{
                System.out.println(-1);
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 10
// 1 2
// 5 6
// 4 2
// 1 1
// 2 1
// 3 3
// 5 1
// 5 4
// 752 18572
// 95152 2322
// OutputCopy
// 2
// 2
// 3
// -1
// -1
// -1
// -1
// -1
// 2
// 3