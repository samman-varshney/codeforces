import java.util.Scanner;
public class coverInWater{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while(tcase-- >0){
            int n = sc.nextInt();
            String str = sc.next();
            int total = 0;
            int count = 0;
            boolean continous = false;

            for(int i=0; i<n; i++){
                if(str.charAt(i) == '.'){
                    total++;
                    count++;
                    if(count == 3){
                        continous = true;
                        break;
                    }
                }else{
                    count = 0;
                }
            }

            if(continous)
                System.out.println(2);
            else
                System.out.println(total);
            
        }
        sc.close();
    }
}