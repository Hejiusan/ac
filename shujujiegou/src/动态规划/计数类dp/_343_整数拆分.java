package 动态规划.计数类dp;

/**
 * https://leetcode.cn/problems/integer-break/description/
 *
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */
public class _343_整数拆分 {
    /**
     * dp[i]：分拆数字i，可以得到的最大乘积为dp[i]
     * 得到 dp[i]的最大乘机，其实可以从1遍历j，然后有两种渠道得到dp[i].
     *
     * 1、拆成两个数：j * (i - j) 直接相乘。
     * 2、拆成3个数以上：j * dp[i - j]，相当于是拆分(i - j)
     *
     * max(dp[i], max((i - j) * j, dp[i - j] * j))
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        if (n <= 2)
            return 1;
        // 初始化
        dp[2] = 1;

        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j <= i/2; j++) {    // 一个数进行拆分成m个数m>=2 那么m值最大也只能是 数的一半
                // 为啥这里还要比较 dp[i]
                /*
                 j每一次遍历都会得出来一个dp[i]的值，遍历所有的j，会有依据这个j得出来的j个dp[i]
                 例如 dp[4]=max(dp[4-j]j,(4-j)j)
                      dp[4]=max(dp[4-1]*1,(4-1)*1)
                      dp[4]=max(dp[4-2]*2,(4-2)*2)
                      dp[4]=max(dp[4-3]*1,(4-3)*3)
                 每一次遍历j都会有dp[4]的更新，如果不和dp[i] 比较，那么dp[i]取到的是j遍历完的那个最大
                 */
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
