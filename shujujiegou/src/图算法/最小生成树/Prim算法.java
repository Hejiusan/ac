package 图算法.最小生成树;

import java.util.Arrays;
import java.util.Scanner;

public class Prim算法 {
    static final int N = 510;
    static final int INF = Integer.MAX_VALUE / 2;  // 避免整数溢出

    static int n, m;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    static int prim() {
        Arrays.fill(dist, INF);
        int res = 0;

        for (int i = 0; i < n; i++) {
            // 1、找到距离生成树最近的那个节点
            int t = -1; // 初始化t为没有找到的点
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            // 不是第一个取出的节点，并且当前节点的距离为INF,则表示没有和集合中点相连的边。
            if (i > 0 && dist[t] == INF) {
                return INF;  // 连通性判断，无法到达某个点
            }

            if (i > 0) {
                res += dist[t];
            }
            // 2、更新当前最短边权点t到集合的距离(保留最小的值，如果比之前最短t到集合的距离还小，更新)
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
            // 3、把这个点加到集合中去
            st[t] = true;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            // 取现有边和新边中的最小值，防止多重边
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }

        int result = prim();

        if (result == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(result);
        }
        scanner.close();
    }
}
