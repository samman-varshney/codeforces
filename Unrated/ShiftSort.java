package Unrated;
import java.util.*;

public class ShiftSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- > 0){
        sc.nextInt();
        String s = sc.next();
        int z = 0;
        for(char c: s.toCharArray()){
            if(c == '0') z++;
        }
        int one = 0;
        for(int i = 0; i < z; i++){
            if(s.charAt(i) == '1') one++;
        }
        System.out.println(one);
        }
        sc.close();
    }
}

// Example
// InputCopy
// 4
// 3
// 001
// 4
// 0110
// 6
// 110100
// 6
// 101011
// OutputCopy
// 0
// 1
// 2
// 1