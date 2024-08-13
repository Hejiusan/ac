package 图算法.最短路算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * ● 初始化距离：dist[1] = 0;  dist[i] = +∞
 * ● 遍历n次 n个点：即进行n次迭代去确定每个点到起点的最小值 最后输出的终点的即为我们要找的最短路的距离
 * ○ 找到不在 s 中的距离最近的点 ==》赋值给 t
 * ○ 用 t 更新其他点的距离
 */
public class Dijkstra {
    static int N = 510;
    static int n, m;    //n个点  m条边
    static int[] dist = new int[N];    //存储每个点到起点的距离
    static boolean[] st = new boolean[N];    //存储每个点是否已经确定为最小距离
    static int[][] g = new int[N][N];    //存图

    //初始化g为无穷
    static {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                g[i][j] = 0x3f3f3f3f;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < m; i++) {
            String[] s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            g[a][b] = Math.min(g[a][b], c); //有向图 a-b之间有一条权重为c的边
        }
        int t = dijkstra();
        System.out.println(t);

    }

    private static int dijkstra() {

        Arrays.fill(dist, 0x3f3f3f3f);    //初始化距离为无穷
        dist[1] = 0;    //第一个点到自身到距离为0
        for (int i = 0; i < n; i++) {
            int t = -1;    //t存储当前访问到点
            for (int j = 1; j <= n; j++) { //j=1 从第一个点开始遍历
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;    //当前的t点 还不是最短点，更新t
            }
            st[t] = true;    //该点点最短路径已经确定，标记为true

            for (int j = 1; j <= n; j++)
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);    //用1～t点距离 + t～j的距离来更新j到起点的距离
        }

        if (dist[n] == 0x3f3f3f3f) return -1;   //如果第n个点为无穷，则说明不存在最短路径
        return dist[n];
    }

}
