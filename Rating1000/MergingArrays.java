package Rating1000;
import java.util.*;
public class MergingArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> a = new HashMap<>();
            Map<Integer, Integer> b = new HashMap<>();
            int prev = -1;
            int cnt = 1;
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                set.add(num);
                if(prev != num){
                    if(a.getOrDefault(prev, 0) < cnt){
                        a.put(prev, cnt);
                    }
                    cnt = 1;
                    prev = num;
                }else{
                    cnt++;
                }
            }
            if(a.getOrDefault(prev, 0) < cnt){
                        a.put(prev, cnt);
            }
            prev = -1;
            cnt = 1;
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                set.add(num);
                if(prev != num){
                    if(b.getOrDefault(prev, 0) < cnt){
                        b.put(prev, cnt);
                    }
                    cnt = 1;
                    prev = num;
                }else{
                    cnt++;
                }
            }
            if(b.getOrDefault(prev, 0) < cnt){
                        b.put(prev, cnt);
            }

            int res = 0;
            for(int key : set){
                res = Math.max(res, a.getOrDefault(key, 0)+b.getOrDefault(key, 0));
            }

            System.out.println(res);

        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 1
// 2
// 2
// 3
// 1 2 3
// 4 5 6
// 2
// 1 2
// 2 1
// 5
// 1 2 2 2 2
// 2 1 1 1 1
// OutputCopy
// 2
// 1
// 2
// 5