import java.util.Scanner;
public class LineTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            int maxDiff = 0;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                if(i!=0){
                    int diff = Math.abs(arr[i] - arr[i-1]);
                    if(diff > maxDiff){
                        maxDiff = diff;
                    }
                }
            }

            int leftvolume = arr[0];
            int rightvolume = 2*(x - arr[n-1]);

            System.out.println(Math.max(maxDiff, Math.max(leftvolume, rightvolume)));

        }
        sc.close();
    }
}


// Example
// InputCopy
// 3
// 3 7
// 1 2 5
// 3 6
// 1 2 5
// 1 10
// 7
// OutputCopy
// 4
// 3
// 7