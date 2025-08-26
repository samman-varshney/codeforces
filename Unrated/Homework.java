package Unrated;

import java.util.Scanner;
public class Homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            sc.nextInt();
            String a = sc.next();
            int m = sc.nextInt();
            String b = sc.next();
            String c = sc.next();

            for(int i=0; i<m; i++){
                if(c.charAt(i) == 'D'){
                    a = a+b.charAt(i);
                }else{
                    a = b.charAt(i) + a;
                }
            }
            System.out.println(a);
        }
        sc.close();
    }
}
// 4
// 2
// ot
// 2
// ad
// DV
// 3
// efo
// 7
// rdcoecs
// DVDVDVD
// 3
// aca
// 4
// bbaa
// DVDV
// 3
// biz
// 4
// abon
// VVDD


// dota
// codeforces
// abacaba
// babizon
