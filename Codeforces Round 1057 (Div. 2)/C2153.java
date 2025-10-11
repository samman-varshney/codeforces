import java.util.*;

public class C2153{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys, (a, b)->(b-a));

            long even = 0;
            int side = 0;
            for(int key: keys){
                int freq = map.get(key)/2;
                even += freq * 2l * key;
                side += freq;
                map.put(key, map.get(key)-freq*2);
            }

            long odd = even;
            int count = 0;
            
            for(int key: keys){
                if(map.get(key) > 0 && key < odd){
                        odd += key;
                        count++;
                        map.put(key, map.get(key)-1);
                        break;
                }
            }
            for(int key: keys){
                if(map.get(key) > 0 && key < odd){
                        odd += key;
                        count++;
                        break;
                }
            }

            System.out.println((side>=2) || (side>=1 && count>=1)? odd: 0);

        }
        sc.close();
    }
}

// Example
// InputCopy
// 5
// 3
// 5 5 7
// 3
// 4 5 7
// 3
// 5 5 10
// 7
// 4 3 5 1 5 3 3
// 4
// 2 3 5 7
// OutputCopy
// 17
// 0
// 0
// 23
// 0



// import java.io.*;
// import java.util.*;

// public class Main {

//     static void CoderAbhi27(Scanner sc) {
//         int n = sc.nextInt();
//         int[] a = new int[n];
//         Map<Integer, Integer> f = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             a[i] = sc.nextInt();
//             f.put(a[i], f.getOrDefault(a[i], 0) + 1);
//         }

//         long ans = 0;
//         Set<Integer> st = new TreeSet<>();
//         int c = 0;

//         for (Map.Entry<Integer, Integer> p : f.entrySet()) {
//             int val = p.getValue();
//             int key = p.getKey();

//             if (val % 2 == 1) st.add(key);

//             ans += 2l * (val / 2l) * key;
//             c += (val / 2) * 2;
//         }

//         if (ans == 0) {
//             System.out.println(0);
//             return;
//         }

//         if (!st.isEmpty()) {
//             List<Integer> sorted = new ArrayList<>(st);
//             Collections.sort(sorted, Collections.reverseOrder()); // descending
//             for (int i = 0; i < sorted.size(); i++) {
//                 int x = sorted.get(i);
//                 if (i == sorted.size() - 1) {
//                     if (ans > x) {
//                         ans += x;
//                         c++;
//                     }
//                 } else {
//                     int y = sorted.get(i + 1);
//                     if (ans + y > x) {
//                         ans += x + y;
//                         c += 2;
//                         break;
//                     }
//                 }
//             }
//         }

//         if (c < 3) System.out.println(0);
//         else System.out.println(ans);
//     }

//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         for (int i = 0; i < t; i++) {
//             CoderAbhi27(sc);
//         }
//     }
// }