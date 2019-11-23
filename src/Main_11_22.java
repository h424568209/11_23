import java.util.Arrays;
import java.util.Scanner;

public class Main_11_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n==0){
                return;
            }
            int []array = new int[n];
            for(int i = 0 ; i < array.length ; i++){
                int x = scanner.nextInt();
                if(x>100||x<0){
                    return;
                }
                array[i] = x;
            }
            int num = scanner.nextInt();
            int count = 0 ;
            for(int i = 0 ; i < n ; i++){
                if(array[i] == num){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
