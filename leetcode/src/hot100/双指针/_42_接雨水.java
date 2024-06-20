package hot100.双指针;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class _42_接雨水 {
    /*
    对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
    下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]
    以每个i对应的柱子为单位
     */
    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        // 分别记录 第i个柱子 从左到右和从右到左的最大高度。
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // 初始化 base case
        l_max[0] = height[0];   // 第一个柱子的最大高度就是本身
        r_max[n - 1] = height[n - 1];
        // 从 第二个柱子开始   从左向右计算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];
        
        return res;
    }

    /**
     * 双指针做法
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        // 特殊情况处理，如果高度数组长度小于等于2，则无法接住雨水
        if (height == null || height.length <= 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;    // 首尾两指针
        int leftMax = 0, rightMax = 0;      // 记录从左到右的最大高度和从右到左的最大高度
        int totalWater = 0;     // 记录总共能接住的与水量
        while (left < right) {
            // 能接多少水是看矮的那条边
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {    // 小了，就会漏，所以直接算接水
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    /**
     * 单调栈解法
     * @param height
     * @return
     */
    public int trap_stack(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

}
