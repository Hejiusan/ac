package 第一讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1050/
 */
public class _1048_鸡蛋的硬度 {
    /*
    状态表示：dp[i][j]: 所有区间长度是 i，且有j个鸡蛋能用的情况下的测量方案数量，求最坏情况下的最小值。
    状态转移：
        1、没有用鸡蛋j  dp[i][j-1]
        2、或者用了鸡蛋j。可能在第k层用了鸡蛋j（不确定是在哪一层用的）
           碎：   dp[k-1][j-1]    在第k层碎了 所以合理区间长度要小于k
           没碎   dp[i-k][j]      在第k层没碎，说明区间应该在【k+1，i】 这个区间里总共有i-k个数 所以区间长度为 i-k
           因为要求的是最坏情况下：所以求最大值 max(dp[k-1][j-1], dp[k-1][j]) + 1 加的1表示的是测的这一次
        整体求最小值
        min（dp[i][j-1]， max(dp[k-1][j-1], dp[k-1][j]) + 1）
     */
    static int N = 110;
    static int M = 11;
    static int[][] dp = new int[N][M];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 1; i <= n; i++) dp[i][1] = i;  // 只有一个鸡蛋，有多少层就得试多少次
            for (int i = 1; i <= m; i++) dp[1][i] = 1;  // 只有一层，不管多少个鸡蛋 也只需要一次

            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    // 第一种情况
                    dp[i][j] = dp[i][j-1];
                    // 第二种情况  在哪一层用到了鸡蛋j
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k-1][j-1], dp[i-k][j]) + 1);
                    }
                }
            }
            System.out.println(dp[n][m]);
        }

    }
}
