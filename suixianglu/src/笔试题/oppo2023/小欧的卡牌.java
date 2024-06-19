package 笔试题.oppo2023;

import java.util.Scanner;

/**
 * 小欧有 n 张卡牌，第 i 张卡牌的正面写了个数字 ai，背面写了个数字 bi。小欧对于每张卡牌可以选择一面向上，
 * 她希望最终向上的数字之和为 3 的倍数。你能告诉小欧有多少方案吗？由于答案过大，请对 10 ^ 9 + 7 取模.
 *
 * 第一行输入一个正整数 n，代表卡牌数量。
 * 接下来的 n 行，每行输入两个正整数 ai 和 bi，代表第 i 张卡牌的正面和背面的数字. 1 <= n <= 10^5 1 <= ai,bi <= 10^9
 */
public class 小欧的卡牌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        /*
        dp[i]: 表示前i张牌中选择向上之后的数字之和为3的倍数的最大方案个数
        递推关系：翻第i张 和不翻
            翻：  a[i] + dp[i-1]
            不翻： dp[i]
         */
        for (int i = 1; i <= n; i++) {

        }
    }
}
