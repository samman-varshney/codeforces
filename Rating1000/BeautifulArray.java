package Rating1000;
import java.util.Scanner;
public class BeautifulArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            long b = sc.nextLong();
            long s = sc.nextLong();

            long min = b*1l*k;
            long max = (n-1l)*(k-1l)+(b+1l)*k-1l;

            if(s<min || s>max)
                System.out.println(-1);
            else{
                long[] arr = new long[n];
                arr[n-1] = k*b;
                long diff = s-min;
                int i = n-1;
                while(diff > 0){
                    long inc = Math.min(diff, k-1);
                    arr[i]+=inc;
                    i--;
                    diff-=inc;
                }
                for(long x : arr)
                    System.out.print(x+" ");
                System.out.println();
            }
        }
        sc.close();
    }
}


// Example
// InputCopy
// 8
// 1 6 3 100
// 3 6 3 12
// 3 6 3 19
// 5 4 7 38
// 5 4 7 80
// 99978 1000000000 100000000 1000000000000000000
// 1 1 0 0
// 4 1000000000 1000000000 1000000000000000000
// OutputCopy
// -1
// -1
// 0 0 19
// 0 3 3 3 29
// -1
// -1
// 0
// 0 0 0 1000000000000000000