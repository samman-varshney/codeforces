package Rating1100;

import java.util.Scanner;
public class CardGame {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- >0) {
            int n = sc.nextInt();
            String card = sc.next();

            if(card.charAt(0) == 'A'){
                //checking bob
               
                int count = 0;
                for (int i = 1; i < n; i++) {
                    if(card.charAt(i) == 'B')
                        count++;
                }
                if(count >= 2 && card.charAt(n-1) == 'B'){
                    System.out.println("Bob");
                }else{
                    System.out.println("Alice");
                }
            }else{
                if(card.substring(n-2, n).equals("AA")){
                    System.out.println("Alice");
                }else{
                    System.out.println("Bob");
                }
            }
        }
        sc.close();
    }
}

// Example
// InputCopy
// 8
// 2
// AB
// 2
// BA
// 4
// ABAB
// 4
// BABA
// 3
// BAA
// 5
// AAAAB
// 5
// BAAAB
// 6
// BBBAAA
// OutputCopy
// Alice
// Bob
// Bob
// Bob
// Alice
// Alice
// Bob
// Alice
