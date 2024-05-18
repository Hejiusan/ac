package 动态规划.背包问题;

import java.io.IOException;
import java.util.Scanner;

public class _01背包 {
    static int N = 1010;
    static int dp[]=new int[N]; // dp[j] 表示背包容量为j所能装的最大价值
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //物品数量
        int m = in.nextInt(); //背包容量
        int[] v = new int[n];   //每个物品的体积
        int[] w = new int[n];   //每个物品的价值
        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {   // 遍历物品数量
            for (int j = m; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-v[i]] + w[i]);
            }
        }
        System.out.println(dp[m]);
    }
}
