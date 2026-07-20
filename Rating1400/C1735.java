package Rating1400;

import java.util.Scanner;
import java.util.Stack;

public class C1735 {
    static int[] size, ultimateParent, immediateParent;

    static int find(int u) {
        if (u == ultimateParent[u])
            return u;
        return ultimateParent[u] = find(ultimateParent[u]);
    }

    static void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            ultimateParent[pv] = pu;
        } else {
            size[pv] += size[pu];
            ultimateParent[pu] = pv;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tacse = sc.nextInt();
        while (tacse-- > 0) {
            int n = sc.nextInt();
            char[] s = sc.next().toCharArray();

            size = new int[26];
            ultimateParent = new int[26];
            immediateParent = new int[26];

            for (int i = 0; i < 26; i++) {
                size[i] = 1;
                ultimateParent[i] = i;
                immediateParent[i] = i;
            }

            Stack<Character> st = new Stack<>();
            for (char c = 'z'; c >= 'a'; c--) {
                st.push(c);
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (immediateParent[s[i] - 'a'] != s[i] - 'a') {
                    res.append((char) (immediateParent[s[i] - 'a'] + 'a'));
                    continue;
                }
                Stack<Character> temp = new Stack<>();
                while (!st.isEmpty() && find(st.peek() - 'a') == find(s[i] - 'a')) {
                    temp.push(st.pop());
                }

                if (st.isEmpty()) {
                    st.push(temp.pop());
                }

                immediateParent[s[i] - 'a'] = st.peek() - 'a';
                union(s[i] - 'a', st.peek() - 'a');
                res.append(st.pop());

                while (!temp.isEmpty()) {
                    st.push(temp.pop());
                }
            }
            System.out.println(res.toString());
        }
        sc.close();
    }
}

// b
// ac
// abcdebfadg
// bcdefghijklmnopqrstuvwxyza
// bcdefghijklmnopqrstuvwxyaz
