package Rating1000;
import java.util.Scanner;
public class ShoeShuffling {
    public static String helper(Scanner sc){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int prev = -1;
        int count = 2;

        for(int i=0; i<n; i++){
            
            if(prev != arr[i]){
                if(count == 1){
                    // System.out.println("first");
                    return "-1";
                }
                count = 1;
                prev = arr[i];
            }else{
                count++;
            }
        }
        if(count==1){
            // System.out.println("Second");
            return "-1";}
        int[] res = new int[n];
        int k=0;
        int i=0;
        while(i<n){
            int j = i;
            while(i<n && arr[i] == arr[j])i++;
            res[k++] = i-1;
            while(k < i){res[k] = j;j++;k++;}
        }
        StringBuilder s = new StringBuilder();
        for(i=0; i<n; i++)
            s.append(res[i]+1+" ");
        // System.out.println("third");
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-->0){
            System.out.println(helper(sc));
        }
        sc.close();
    }
}

// Example
// InputCopy
// 2
// 5
// 1 1 1 1 1
// 6
// 3 6 8 13 15 21
// OutputCopy
// 5 1 2 3 4 
// -1
// Input
// 2
// 7
// 2 2 3 3 3 4 4
// 6
// 1 2 2 2 3 3
// Participant's output
// 2 1 5 1 2 7 1 
// -1
// Jury's answer
// 2 1 5 3 4 7 6 
// -1