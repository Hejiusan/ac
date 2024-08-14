package 图算法.最短路算法;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 n 个点 m条边的有向图，图中可能存在重边和自环， 边权可能为负数。
 * 请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 impossible。
 * 数据保证不存在负权回路。
 */
public class spfa {
    static int n, m, N = 100010;
    static Queue<Integer> q = new LinkedList<>();
    static int[] dist = new int[N];//距离数组
    static boolean[] st = new boolean[N];//标记数组
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N];//邻接表
    static int idx;
    /*
    算法流程
        ● 建立一个队列，初始时队列里只有起始点。
        ● 再建立一个数组记录起始点到所有点的最短路径（该表格的初始值要赋为极大值，该点到他本身的路径赋为0）。
        ● 再建立一个数组st[]，标记点是否在队列中。
        ● 队头不断出队，计算始点起点经过队头到其他点的距离是否变短，如果变短且被点不在队列中，则把该点加入到队尾。
        ● 重复执行直到队列为空。
        ● 在保存最短路径的数组中，就得到了最短路径。
     */
    static void spfa() {
        Arrays.fill(dist, 0x3f3f3f3f);  // 初始化最短路径为极大值
        dist[1] = 0;//初始化第一个点到自身的距离

        q.offer(1); //1号点入队
        st[1] = true;   //1号点在队列里了  标记一下

        while (!q.isEmpty()) {
            int t = q.poll();   //取对头, 并且出队
            st[t] = false;  //不再队列里了

            //更新t的所有邻边
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]){    //如果没在队列中 就入队 并且打标记
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        if (dist[n] == 0x3f3f3f3f) System.out.println("impossible");
        else System.out.println(dist[n]);
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        n = Integer.parseInt(params[0]);
        m = Integer.parseInt(params[1]);
        Arrays.fill(h, -1);
        for (int i = 1; i <= m; ++i) {
            String[] info = buf.readLine().split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            int c = Integer.parseInt(info[2]);
            add(a, b, c);
        }
        spfa();

    }
}
