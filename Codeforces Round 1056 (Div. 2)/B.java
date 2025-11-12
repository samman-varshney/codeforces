import java.util.*;

public class B
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if(n*n != k && n*n - k < 2){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                char[][] arr = new char[n][n];
                for(char[] x: arr)
                    Arrays.fill(x, 'D');
                for(int i=0; i<n; i++){
                    if(i < n-1){
                        arr[n-1][i] = 'R';
                    }
                }
                arr[n-1][n-1] = 'L';
                int fullLines = k/n;
                for(int i=0; i<fullLines; i++){
                    Arrays.fill(arr[i], 'U');
                }
                int halfLine = k%n;
                for(int i=0; i<halfLine; i++){
                    arr[fullLines][i] = 'U';
                }
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
            }

        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 2 4
// 3 5
// 2 3
// OutputCopy
// YES
// UU
// UU
// YES
// UUU
// RDR
// ULR
// NO