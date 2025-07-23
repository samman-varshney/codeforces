package Rating1000;
import java.util.Scanner;
public class LukeisaFoodie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            int res = 0;
            int min = arr[0], max = arr[0];
            for(int i =1; i<n; i++){
                int ai = arr[i];
                if( ai < min){
                    if(Math.abs((max-ai+1)/2) <= x){
                        min = ai;
                    }else{
                        res++;
                        min = ai;
                        max = ai;
                    }
                }else if(ai > max){
                    if(Math.abs((ai - min +1)/2) <= x){
                        max = ai;
                    }else{
                        res++;
                        min = ai;
                        max = ai;
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
// 7
// 5 3
// 3 8 5 6 7
// 5 3
// 3 10 9 8 7
// 12 8
// 25 3 3 17 8 6 1 16 15 25 17 23
// 10 2
// 1 2 3 4 5 6 7 8 9 10
// 8 2
// 2 4 6 8 6 4 12 14
// 8 2
// 2 7 8 9 6 13 21 28
// 15 5
// 11 4 13 23 7 10 5 21 20 11 17 5 29 16 11
// OutputCopy
// 0
// 1
// 2
// 1
// 2
// 4
// 6