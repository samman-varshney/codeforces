package Binary_lifting;

import java.io.*;
import java.util.*;

public class RMI20_sumzero {
    static final int val = 400;
    static int n, q, l, r;
    static int[] nxt = new int[400005];
    static int[] nxtcan = new int[400005];
    static int[] pw = new int[30];
    static Map<Long, Long> mp = new HashMap<>();
    static long[] c = new long[400005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Fast input equivalent
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        pw[0] = 1;
        nxt[n + 1] = n + 1;

        for (int i = 1; i <= 18; i++) {
            pw[i] = pw[i - 1] * 2;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            c[i] = Long.parseLong(st.nextToken());
            c[i] += c[i - 1];

            if (mp.get(c[i]) != null && mp.get(c[i]) != 0) {
                nxt[mp.get(c[i]).intValue()] = i;
            }
            if (c[i] == 0 && (mp.get(c[i]) == null || mp.get(c[i]) == 0)) {
                nxt[0] = i;
            }
            mp.put(c[i], (long) i);
        }

        for (int i = 0; i <= n; i++) {
            if (nxt[i] == 0)
                nxt[i] = n + 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            nxt[i] = Math.min(nxt[i], nxt[i + 1]);
        }

        nxtcan[n + 1] = n + 1;
        for (int i = 0; i <= n; i++) {
            if (i > 0 && nxt[i] == nxt[i - 1]) {
                nxtcan[i] = nxtcan[i - 1];
                continue;
            }
            int cur = i;
            for (int j = 1; j <= 50; j++) {
                cur = nxt[cur];
                if (cur == n + 1)
                    break;
            }
            nxtcan[i] = cur;
        }

        for (int i = 0; i <= n; i++) {
            nxtcan[i] = nxtcan[nxtcan[nxtcan[nxtcan[nxtcan[nxtcan[nxtcan[nxtcan[i]]]]]]]];
        }

        st = new StringTokenizer(br.readLine());
        q = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int query = 1; query <= q; query++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            int cur = l - 1;
            int res = 0;

            while (true) {
                if (nxtcan[cur] <= r) {
                    res += val;
                    cur = nxtcan[cur];
                } else
                    break;
            }

            while (true) {
                if (nxt[cur] <= r) {
                    res++;
                    cur = nxt[cur];
                } else
                    break;
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}