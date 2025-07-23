package Unrated;
import java.util.*;
public class forked{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int xk = sc.nextInt();
            int yk = sc.nextInt();
            int xq = sc.nextInt();
            int yq = sc.nextInt();
            int[] d1 = {-1, 1};
            int[] d2 = {1, -1};
            HashSet<String> king = new HashSet<>();
            HashSet<String> queen = new HashSet<>();
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    king.add((xk+d1[i]*a) + ","+ (yk+d2[j]*b));
                    king.add((xk+d1[i]*b) + ","+ (yk+d2[j]*a));
                    queen.add((xq+d1[i]*b) + ","+ (yq+d2[j]*a));
                    queen.add((xq+d1[i]*a) + ","+ (yq+d2[j]*b));
                }
            }
            king.retainAll(queen);
            System.out.println(king.size());
        }
        sc.close();
    }
}


