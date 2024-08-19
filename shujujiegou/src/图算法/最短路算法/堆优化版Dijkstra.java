package 图算法.最短路算法;

import java.io.*;
import java.lang.*;
import java.util.*;

class 堆优化版Dijkstra {
    static int n = 0, m = 0, N = 1000010;
    static PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));//小根堆
    static int[] dist = new int[N];//距离数组
    static boolean[] f = new boolean[N];//标记数组
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N];//邻接表
    static int idx = 1;

    static int Dijkstra() {//类似广搜的过程
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;//初始化第一个点到自身的距离
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int t = a[0], distance = a[1];
            if (f[t]) continue;
            f[t] = true;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    q.offer(new int[]{j, dist[j]});
                }
            }
        }
        if (dist[n] != 0x3f3f3f3f) return dist[n];
        return -1;
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
        n = Integer.valueOf(params[0]);
        m = Integer.valueOf(params[1]);
        Arrays.fill(h, -1);
        for (int i = 1; i <= m; ++i) {
            String[] info = buf.readLine().split(" ");
            int a = Integer.valueOf(info[0]);
            int b = Integer.valueOf(info[1]);
            int c = Integer.valueOf(info[2]);
            add(a, b, c);
        }
        System.out.print(Dijkstra());

    }
}

