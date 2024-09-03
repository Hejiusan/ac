package 面试150.数组_字符串;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class _135_分发糖果 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        // 每个孩子都有一个糖果
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]){
                // 如果左侧评分高的，要比左侧的孩子多一个苹果
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }
        // 计算糖果总数
        int sum = 0;
        for (int candy : candies) {
            sum+=candy;
        }
        return sum;
    }


}
