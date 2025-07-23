package Rating1000;
import java.util.*;

public class HelmetinNightLight{
    static class Pair{
        int capacity, cost;
        public Pair(int capacity, int cost){
            this.capacity = capacity;
            this.cost = cost;
        }
    }
    public static long helper(int[][] arr, int p){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->(a.cost!=b.cost?a.cost-b.cost:b.capacity-a.capacity));
        Queue<Pair> q = new LinkedList<>();

        for(int[] x : arr){
            pq.add(new Pair(x[0], x[1]));
        }
        long total = 0;
        if(pq.peek().cost < p){
            q.add(pq.remove());
            total+=p;
        }
        while(!q.isEmpty() && !pq.isEmpty()){
            Pair p1 = q.remove();
            while(!pq.isEmpty() && p1.capacity>0){
                Pair p2 = pq.poll();
                if(p2.cost < p){
                    q.add(p2);
                }
                total+=p1.cost;
                p1.capacity--;
            }
        }

        total += pq.size() * 1l*p;
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[][] person = new int[n][2];
            

            for(int i=0; i<n; i++){
                person[i][0] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                person[i][1] = sc.nextInt();
            }
            // Arrays.sort(person, (a, b)->(a[1]!=b[1]?a[1]-b[1]:b[0]-a[0]));
            // for(int i=0; i<n; i++){
            //     System.out.println(Arrays.toString(person[i]));
            // }
            // long totalcost = 0;
            // int i = 0;
            // while(i<person.length && person[i][1] < p && n>0){
            //     totalcost+=p;
            //     n-=1;
            //     int share = Math.min(n, person[i][0]);
            //     n-=share;
            //     totalcost+=share*person[i][1];
            //     i++;
            // }

            // if(n > 0){
            //     totalcost+=n*p;
            // }
            // System.out.println(totalcost);
            System.out.println(helper(person, p));

        }
        sc.close();
    }
}

// Example
// InputCopy
// 3
// 6 3
// 2 3 2 1 1 3
// 4 3 2 6 3 6
// 1 100000
// 100000
// 1
// 4 94
// 1 4 2 3
// 103 96 86 57
// OutputCopy
// 16
// 100000
// 265
// 5 4
// 2 2 3 1 1
// 1 1 3 3 2