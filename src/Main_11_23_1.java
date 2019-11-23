import java.util.*;

public class Main_11_23_1 {
    //存放所有有可能的出栈序列
    private static List<int[]> list = new ArrayList<>();
    //存放最终所有合法的出栈序列
    private static List<String>res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        int []arr=  new int[N];
        for(int i= 0 ; i < N ; i++){
            int x = scanner.nextInt();
            arr[i] = x;
        }
        backTrace(N,arr,0);
        for(int[]t:list){
            if(isLegal(arr,t,N)){
                String s = addToStr(t,N);
                res.add(s);
            }
        }
        //对最终的结果按字典序排序后输出
        Collections.sort(res);
        for(String r : res){
            System.out.println(r);
        }
    }
    //判断出栈序列是否合法
    //将进栈序列依次压入栈中，如果栈顶元素和出栈序列元素相同，那么栈顶元素出栈
    //直到进栈序列元素全部压栈
    //最后如果栈空，说明出栈序列合法；否则出栈序列就是不合法
    private static boolean isLegal(int[] in, int[] out, int n) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0 ; i<n ; i++){
            stack.push(in[i]);
            while(j<n && !stack.isEmpty() && out[j] == stack.peek()){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    //数组变成字符串，方便最后结果按字典序进行排列
    private static String addToStr(int[] t, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < n ; i++){
            sb.append(t[i]);
            if(i!=n-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //所有的可能出栈序列
    private static void backTrace(int n, int[] arr, int beginIndex) {
        //此时只剩下一个元素 不需要进行交换
        if(beginIndex == n-1){
            int []tmp = arr.clone();
            list.add(tmp);
            return;
        }
        for(int i = beginIndex ; i < n ;i++){
            swap(arr,i,beginIndex);
            backTrace(n,arr,beginIndex+1);
            swap(arr,i,beginIndex);
        }
    }

    private static void swap(int[] arr, int i, int beginIndex) {
        int t = arr[i];
        arr[i] = arr[beginIndex];
        arr[beginIndex] = t;
    }
}
