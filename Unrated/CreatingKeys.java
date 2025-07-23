package Unrated;
import java.util.*;

public class CreatingKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();

        while (tcase-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            Stack<Integer> q = new Stack<>();

            int num = 0, res = 0, i = 0;
            while (i < n) {
                if ((num | x) == x) {
                    q.push(num);
                    res |= num;
                    i++;
                }
                if (q.size() == n) {
                    if (res != x) {
                        q.pop();
                        i--;
                    }
                }
                num++;
            }

            while (!q.isEmpty()) {
                System.out.print(q.pop() + " ");
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 9
// 1 69
// 7 7
// 5 7
// 7 3
// 8 7
// 3 52
// 9 11
// 6 15
// 2 3
// OutputCopy
// 69
// 6 0 3 4 1 2 5
// 4 1 3 0 2
// 0 1 2 3 2 1 0
// 7 0 6 1 5 2 4 3
// 0 52 0
// 0 1 8 3 0 9 11 2 10
// 4 0 3 8 1 2
// 0 3
