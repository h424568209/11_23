import java.util.Stack;

public class LeeCode {
    /**
     * 求一个二维数组中最大的矩形面积
     * 进行叠加，二维数组中的每一个元素都是一个一维数组，可以求出每个一维数组的最大的面积，
     * 进而求出这个二维数组的最大的矩形面积
     * @param matrix 二维数组
     * @return 最大的矩形面积
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //进行叠加 至二维数组的最大值
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, largestRectangleArea(dp));
            System.out.println(maxarea);
        }
        return maxarea;
    }

    /**
     * 柱状图形中的最大面积
     * 维护一个栈 一开始，把-1放入栈中，开始将柱子的序号放入栈中，知道遇到了柱子呈下降的关系
     *
     * @param heights 数组
     * @return 最大的面积
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // 若是下降的关系 则进行计算最大的面积
            //栈顶始终时当前的一个下降趋势的元素的下标
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            //若呈上升的关系  一直入栈
            stack.push(i);
        }
        // 当到数组中的元素还有除了-1之外的别的时 ，更新max
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 3, 2};
        LeeCode l = new LeeCode();
        System.out.println(l.largestRectangleArea(heights));
        char max[][] = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(l.maximalRectangle(max));
    }
}