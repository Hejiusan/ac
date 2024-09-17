package 第六讲;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/94/
 * <p>
 * 从 1∼n 这 n 个整数中随机选取任意多个，输出所有可能的选择方案。
 */
public class _92_递归实现指数型枚举 {
    static int n;
    static boolean[] st = new boolean[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(1);
    }

    private static void dfs(int u) {
        // 结束条件
        if (u > n) {
            for (int i = 1; i <= n; i++) {
                if (st[i]) System.out.printf(i + " ");
            }
            System.out.println();
            return;
        }
        // 标记当前数，在递归下一个分支
        st[u] = true;
        dfs(u + 1);   // 选当前数的分支
        st[u] = false;
        dfs(u + 1);   // 不选当前数的分支
    }
}
