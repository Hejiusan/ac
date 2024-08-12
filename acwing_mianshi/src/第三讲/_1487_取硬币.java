package 第三讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1489/
 * 现在有 n1+n2 种面值的硬币，其中前 n1 种为普通币，可以取任意枚，后 n2 种为纪念币，每种最多只能取 1 枚，每种硬币有一个面值，
 * 问能用多少种方法拼出 m 的面值？
 * 输入格式
 * 第一行包含三个整数 n1,n2,m，分别表示普通币种类数，纪念币种类数和目标面值；
 * 第二行 n1 个整数，第 i 种普通币的面值 a[i]。保证 a[i]为严格升序；
 * 第三行 n2 个整数，第 i 种纪念币的面试 b[i]。保证 b[i]为严格升序。
 *
 * 输出格式
 * 共一行，包含一个整数 x，表示方法总数对 109+7取模后的结果。
 */
public class _1487_取硬币 {
    /*
    状态表示：dp[i][j]：所有只从前i个银币里选，且总面值是j的选法个数
    状态计算：第i个物品选 or 不选
        不选第i个硬币
            普通硬币： dp[i][j] = dp[i - 1][j] + dp[i - 1][j - v] + dp[i - 1][j - 2 * v] + dp[i - 1][j - 3 * v] + ...
            优化后 ==》 dp[i][j] = dp[i - 1][j] + dp[i][j - v];

            纪念币:   dp[i][j] = dp[i-1][j-b[i]]        01背包
        选 第 i个硬币
            dp[i][j]
     */
    static int n1, n2, m;
    static int[] a;  // 普通硬币
    static int[] b;  // 纪念币
    static int[] f = new int[10010];
    static int mod = (int)1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        n1 = Integer.parseInt(s[0]);
        n2 = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[2]);

        a = new int[n1];
        b = new int[n2];

        s = sc.nextLine().split(" ");
        for (int i = 0; i < n1; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        s = sc.nextLine().split(" ");
        for (int i = 0; i < n2; i++) {
            b[i] = Integer.parseInt(s[i]);
        }
        int cnt = dpProcessPlus();
        System.out.println(cnt);

    }

    // 优化成一维数组，时间复杂度：O(n * m)
    public static int dpProcessPlus() {
        f[0] = 1;
        // 分情况
        // 纪念币从前往后遍历
        for (int i = 0; i < n1; i++) {
            for (int j = a[i]; j <= m; j++) {
                f[j] = (f[j] +f[j - a[i]]) % mod;
            }
        }

        // 普通币
        for (int i = 0; i < n2; i++) {
            for (int j = m; j >= b[i]; j--) {
                f[j] = (f[j] + f[j - b[i]]) % mod;
            }
        }

        return f[m];
    }

}
