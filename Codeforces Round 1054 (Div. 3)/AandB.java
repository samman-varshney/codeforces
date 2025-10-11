import java.util.Scanner;

public class AandB {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            System.out.println(solve(sc));
        }
    }

    private static long solve(Scanner sc) {
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        
        //trying to bring all a's together
        long costA = countMinSwaps('a', 'b', s);
        //trying to bring all b's together
        long costB = countMinSwaps('b', 'a', s);

        return Math.min(costA, costB);

    }

    public static long countMinSwaps(char match, char unMatch, char[] s){
        int n = s.length;
        int start = n, end = -1;
        for(int i=0; i<n; i++){
            if(s[i] == match){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        long minOp = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int last = start;
        for(int i=start; i<end; i++){
            if(s[i] == unMatch){
                left[i] = i-last;
                last++;
            }
        }
        last = end;
        for(int i=end; i>=start; i--){
            if(s[i] == unMatch){
                right[i] = last-i;
                last--;
            }
        }

        for(int i=0; i<n; i++){
            minOp += Math.min(left[i], right[i]);
        }
        return minOp;
    }
}


// Example
// InputCopy
// 5
// 4
// abab
// 6
// bababa
// 7
// abababa
// 2
// ab
// 1
// b
// OutputCopy
// 1
// 2
// 2
// 0
// 0



