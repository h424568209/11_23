import java.util.ArrayList;
import java.util.Scanner;

public class Main_11_22_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数据组
        StringBuilder re = new StringBuilder();
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                //每个数据组的第一行两个数 n，k
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int[] arr = new int[2 * n];
                //2n个数 表示原始组从上到下的序列
                for (int j = 0; j < 2 * n; j++) {
                    arr[j] = scanner.nextInt();
                }
                for (int m = 0; m < k; m++) {
                    reverse(arr, arr.length);
                }
                for (int a = 0; a < 2 * n -1; a++) {
                    System.out.print(arr[a]+" ");
                }
                System.out.println(arr[n*2-1]);
            }
        }
    }
    private static void reverse(int[] arr, int length) {
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i = 0 ; i < length/2 ; i++){
            list.add(arr[i]);
            list.add(arr[i+length/2]);
        }
        for(int i = 0 ; i < length ; i++){
            arr[i] = list.get(i);
        }
    }
}
