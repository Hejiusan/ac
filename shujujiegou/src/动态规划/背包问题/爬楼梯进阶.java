package 动态规划.背包问题;

import java.util.Scanner;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class 爬楼梯进阶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        /*
        dp[i]: 爬到第i个台阶的所有方法
        dp[i]可以由 dp[i-j] 在跳j个台阶得来
        所以递推公式：dp[i] += dp[i-j]
         */

        int[] dp = new int[n+1];

        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }
        System.out.println(dp[n]);
    }
}
