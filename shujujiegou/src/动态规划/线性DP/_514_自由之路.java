package 动态规划.线性DP;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/freedom-trail/description/
 * 电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，
 * 然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 */
public class _514_自由之路 {
    /*
    定义 dp[i][j] 表示从 key 的第 i 个字符对齐至 ring 的第 j 个字符所需要的最少步数。
    状态转移：
        对于每个 key[i]，你需要在 ring 中找到所有的字符 ring[j] 等于 key[i]，然后计算到达这些位置的最小步数。
        假设我们现在要对齐 key[i] 至 ring[j]，我们需要查看上一个字符 key[i-1] 在 ring 上所有可能的位置 k，
        计算从 k 转到 j 的最小步骤数。转动的步数是 min(abs(j-k), len(ring)-abs(j-k)) 加上按下中心按钮的一步。
     */
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int j = 0; j < n; j++) {
            if (ring.charAt(j) == key.charAt(0)) {
                dp[0][j] = Math.min(j, n - j) + 1;
            }
        }

        // Fill for the rest of characters in key
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ring.charAt(j) == key.charAt(i)) {
                    for (int k = 0; k < n; k++) {
                        if (ring.charAt(k) == key.charAt(i - 1)) {
                            int steps = Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1; // +1 是因为按按钮也算一次
                            dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + steps);
                        }
                    }
                }
            }
        }

        // Find the minimum steps required to form the last character of key
        int minSteps = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSteps = Math.min(minSteps, dp[m-1][j]);
        }

        return minSteps;
    }
}
