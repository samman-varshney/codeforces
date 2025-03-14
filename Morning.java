import java.util.Scanner;

public class Morning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        sc.nextLine();
        while (tcase-- > 0) {
            String a = sc.nextLine();
            int step = 0;
            int lastidx = 0;
            int curridx;

            for (int i = 0; i < a.length(); i++) {
                int num = a.charAt(i) - '0';
                curridx = num != 0 ? num - 1 : 9;
                step += Math.abs(lastidx - curridx) + 1;
                lastidx = curridx;
            }
            System.out.println(step);
        }

        sc.close();
    }
}
// InputCopy
// 10
// 1111
// 1236
// 1010
// 1920
// 9273
// 0000
// 7492
// 8543
// 0294
// 8361
// OutputCopy
// 4
// 9
// 31
// 27
// 28
// 13
// 25
// 16
// 33
// 24