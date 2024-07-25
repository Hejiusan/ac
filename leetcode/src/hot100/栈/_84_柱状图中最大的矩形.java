package hot100.栈;

import java.util.*;

/**
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class _84_柱状图中最大的矩形 {
    // 维护一个单调递增的单调栈
    static Stack<Integer> stk = new Stack<>();
    static int res = 0;
    /*
    找每个柱子左右两边第一个小于该柱子的柱子。
     */
    public static int largestRectangleArea(int[] heights) {
        /*
        在元素首尾都加一个0；防止数组单调时无法进入while循环里的面积计算逻辑
         */
        // 创建一个新的数组，长度为原数组的长度加2
        int[] newArray = new int[heights.length + 2];

        // 头部添加0
        newArray[0] = 0;

        // 复制原数组元素到新数组
        System.arraycopy(heights, 0, newArray, 1, heights.length);

        // 尾部添加0
        newArray[newArray.length - 1] = 0;

        heights = newArray;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            // 当前遍历的格子比栈顶小，计算最大矩形
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                int top = stk.pop();
                if (stk.isEmpty()) {
                    break;
                }
                int left = stk.peek();
                int currWidth = i - left - 1;
                // 栈顶 和栈顶的下一个元素 以及要 入栈 的 三个元素组成了我们要求最大面积的高度和宽度
                int area = heights[top] * currWidth;
                res = Math.max(area, res);
            }

            stk.push(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] heights = new int[]{0,1,1};
        System.out.println(largestRectangleArea(heights));
    }
}
