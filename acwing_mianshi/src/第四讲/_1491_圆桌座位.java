package 第四讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1493/
 * N 个人围坐一圈，有 M 对朋友关系。
 *
 * 第 i 对朋友关系是指，编号是 ai 的人和编号是 bi 的人是朋友。
 * 现在要给他们安排座位，要求所有相邻的人不能是朋友。问共有多少种方案？
 *
 * 如果两个方案只有旋转角度不同，则我们将其视为一种方案。
 */
public class _1491_圆桌座位 {
    static int N = 11;
    static int[] pos = new int[N];  // 记录每个数的位置
    static boolean[][] g = new boolean[N][N];   // 存在朋友关系
    static boolean[] st = new boolean[N];   // 标记这个数是否被用过
    static int n,m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        n = Integer.parseInt(s[0]); // N 个人
        m = Integer.parseInt(s[1]); // m 对关系
        for (int i = 0; i < m; i++) {
            s = sc.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            g[a][b] = g[b][a] = true;
        }

        // 因为旋转不变，所以可以固定1为起点
        // 考虑dfs 往下搜
        pos[0] = 1;
        st[1] = true;
        int res = dfs(1);
        System.out.println(res);
    }

    private static int dfs(int u) {
        // 递归结束条件
        if (u == n){
            // 因为是首尾相连的，所以也要考虑他俩是不是朋友关系
            if (g[pos[n-1]][pos[0]])    return 0;
            else return 1;
        }

        int res = 0;
        // 遍历下一个数字
        for (int i = 1; i <= n; i++) {
            // 如果这个数字还没被使用，并且和当前数不是朋友关系 (pos[]返回的是所在位置的这个数，记得-1)
            if (!st[i] && !g[i][pos[u-1]]){
                pos[u] = i;
                st[i] = true;
                res += dfs(u+1);
                // 恢复现场
                st[i] = false;
            }
        }
        return res;
    }
}
