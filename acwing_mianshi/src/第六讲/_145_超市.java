package 第六讲;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/147/
 *
 * 超市里有 N 件商品，每件商品都有利润 pi 和过期时间 di ，每天只能卖一件商品，过期商品不能再卖。
 * 求合理安排每天卖的商品的情况下，可以得到的最大收益是多少。
 */
public class _145_超市 {
    public static int maxProfit(int[][] products) {
        // 对商品按过期时间排序，如果相同，则按利润降序排序
        Arrays.sort(products, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 默认小根堆
        int totalProfit = 0;
        int count = 0;
        // 遍历所有商品
        for (int[] product : products) {
            int profit = product[0];
            int deadline = product[1];

            if (count < deadline) {
                minHeap.add(profit);
                totalProfit += profit;
                count++;
            } else if (!minHeap.isEmpty() && minHeap.peek() < profit) { // 物品个数大于天数了，去掉利润最低的商品
                totalProfit += profit - minHeap.poll(); // 加上新的更大的利润 并且减去堆顶元素（利润最低的商品）
                minHeap.add(profit);    // 把新的商品加进去
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] products = new int[n][2];

            for (int i = 0; i < n; i++) {
                int profit = sc.nextInt();
                int deadline = sc.nextInt();
                products[i][0] = profit;    // 利润
                products[i][1] = deadline;  // 过期时间
            }

            int maxProfit = maxProfit(products);
            System.out.println(maxProfit);
        }

        sc.close();
    }
}
