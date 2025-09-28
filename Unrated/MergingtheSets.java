package Unrated;
import java.util.*;

public class MergingtheSets{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] freq = new int[m+1];
            int count = 0;

            ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
            for(int i=0; i<n; i++){
                int l = sc.nextInt();
                sets.add(new ArrayList<>());
                for(int j=0; j<l; j++){
                    int num = sc.nextInt();
                    count += freq[num]==0?1:0;
                    freq[num]++;
                    sets.get(i).add(num);
                }
            }

            if(count != m){
                System.out.println("NO");
            }else{
                int unImportant = n;
                for(int i=0; i<n; i++){
                    
                    for(int num: sets.get(i)){
                        if(freq[num] == 1){
                            unImportant--;
                            break;
                        }
                    }
                }
                if(unImportant <= 1){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 6
// 3 2
// 2 1 2
// 1 1
// 1 2
// 4 10
// 3 1 2 3
// 2 4 5
// 1 6
// 4 7 8 9 10
// 2 5
// 4 1 2 3 4
// 4 1 2 3 4
// 5 5
// 5 1 2 3 4 5
// 5 1 2 3 4 5
// 5 1 2 3 4 5
// 5 1 2 3 4 5
// 5 1 2 3 4 5
// 5 10
// 4 1 2 3 4
// 5 1 2 5 6 7
// 5 2 6 7 8 9
// 4 6 7 8 9
// 2 9 10
// 5 5
// 1 1
// 1 2
// 1 3
// 2 4 5
// 1 5
// OutputCopy
// YES
// NO
// NO
// YES
// YES
// NO