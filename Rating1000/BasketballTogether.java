package Rating1000;
import java.io.*;
import java.util.*;

public class BasketballTogether {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n  = Integer.parseInt(st.nextToken());
        long D = Long.parseLong(st.nextToken());          // keep it exact

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);                                   // O(n log n)

        int res = 0;
        for(int i=arr.length-1; i>=0; i--){
            int member = (int)Math.ceil((D+1.0)/arr[i]);
            if(member <= n){
                res++;
                n-=member;
            }else
                break;
        }
        System.out.println(res);
    }
}
