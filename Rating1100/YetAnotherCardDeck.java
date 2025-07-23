package Rating1100;

import java.util.*;
class Pair{
    int idx;
    int val;

    public Pair(int val, int idx){
        this.idx = idx;
        this.val = val;
    }
}
public class YetAnotherCardDeck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n = sc.nextInt();
            int q = sc.nextInt();

            int[] marked = new int[51];
            Deque<Pair> pq = new ArrayDeque<>();
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                if(marked[num] == 0){
                    marked[num] = 1;
                    pq.addFirst(new Pair(num, i+1));
                }
            }
            Stack<Pair> s = new Stack<>();
            while(!pq.isEmpty()){
                s.push(pq.removeLast());
            }
            ArrayList<Integer> res = new ArrayList<>();
            for(int i=0; i<q; i++){
                int query = sc.nextInt();
                Stack<Pair> temp = new Stack<>();
                while(s.peek().val != query){
                    s.peek().idx += 1;
                    temp.push(s.pop());
                }
                res.add(s.pop().idx);
                while(!temp.isEmpty()){
                    s.add(temp.pop());
                }
                s.push(new Pair(query, 1));
            }
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
            }
            System.out.println();
      
        sc.close();
    }
}

// Example
// InputCopy
// 7 5
// 2 1 1 4 3 3 1
// 3 2 1 1 4
// OutputCopy
// 5 2 3 1 5 