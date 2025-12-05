import java.util.*;
public class sample {
    public static int minOperations(List<Integer> prices, int k, int d) {
        int n = prices.size();
        long sum = 0;
        int minA = Integer.MAX_VALUE, maxA = Integer.MIN_VALUE;
        for (int x : prices) {
            sum += x;
            if (x < minA) minA = x;
            if (x > maxA) maxA = x;
        }
        long best = Integer.MAX_VALUE;
        long low = (long)Math.floorDiv(sum - (long)n * (d - 1) + (n - 1), n); 
        // ceil((sum - n*(d-1))/n) implemented safely
        long high = sum / n;
        if (low > high) {
            // no L in this range; expand search conservatively to cover possible L values
            low = Math.max(0, minA - d - 5);
            high = maxA + 5;
        }
        for (long L = low; L <= high; L++) {
            long upper = L + d - 1;
            if (n * L > sum || n * upper < sum) continue;
            long needChunks = 0;
            long giveChunks = 0;
            for (int a : prices) {
                if (a < L) {
                    long need = L - a;
                    needChunks += (need + k - 1) / k;
                } else if (a > upper) {
                    long give = a - upper;
                    giveChunks += (give + k - 1) / k;
                }
            }
            long ops = Math.max(needChunks, giveChunks);
            if (ops < best) best = ops;
        }
        return best == Integer.MAX_VALUE ? -1 : (int)best;
    }

    public static void main(String[] args) {
        Integer k = 100;
        Integer m = 300;
        Integer temp = k;
        k = m;
        m = temp;
        System.out.println(k+" "+m);//values get swapped

        swap(k, m);
        System.out.println(k+" "+m);

        String s = "234";
        String t = "345";

        swap(s, t);
        System.out.println(s+" "+t);
    }

    public static void swap(Integer k, Integer m){
        Integer temp = k;
        k = m;
        m = temp;
    }

    static void swap(String s, String t){
        String temp = s;
        s = t;
        t = temp;
    }


}
