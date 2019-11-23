import java.util.Scanner;

public class Main_11_21_1 {
    // 输入数据时由是个数字组成 便是0-9的出现次数
    // 组成最小的数字
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num[] = new int[10];
        for(int i= 0 ; i < 10 ;i++){
            num[i] = scanner.nextInt();
        }
        for(int i = 1 ; i < 10 ; i ++){
            if(num[i] != 0){
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        while(num[0]!=0){
            System.out.print(0);
            num[0]--;
        }
        for(int i= 1 ; i < 10 ; i++){
            while(num[i]!=0){
                System.out.print(i);
                num[i]--;
            }
        }
    }
}
