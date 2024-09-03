package 第三讲;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
    这题对我来说最直接的理解方法就是要求从特定村庄到任意商店的最短距离。从这个角度看，我们用一个虚拟点将所有的商店连接在一起，且边长为0，
    此时求特定村庄到任意商店的最短距离就转变成了求特定村庄到该虚拟点的距离。换句话说，此时多源点多汇点最短路问题就转变成了多源点单汇点问题，
    如果我们将汇点视为源点而源点视为汇点，该问题就是一个典型的单源最短路问题，使用djs算法求解该虚拟点到所有村庄的距离所得到的dist[i]
    即该虚拟点到村庄i的最短距离，就是村庄i到任意商店的最短距离
 */
class Pair implements Comparable<Pair> {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.second, o.second);
    }
}

public class _1488_最短距离 {

    // 堆优化版djs
    public static int[] djs(int src, int n, ArrayList<ArrayList<int[]>> map) {
        int[] dist = new int[n + 1];    // src到某点的距离
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[src] = 0;
        boolean[] st = new boolean[n + 1];
        PriorityQueue<Pair> pairs = new PriorityQueue<>();
        pairs.add(new Pair(src, 0));
        while (!pairs.isEmpty()) {
            Pair node = pairs.poll();
            // Pair第一个元素为村庄编号，第二个元素为src到该村庄的距离
            int t = node.first, distance = node.second;
            // 如果该点已经被确定就跳过
            if (st[t]) continue;
            // 否则用这个点更新src到该点能到达的点的距离
            for (int[] point : map.get(t)) {
                if (dist[point[0]] > distance + point[1]) {
                    dist[point[0]] = distance + point[1];
                    pairs.add(new Pair(point[0], dist[point[0]]));
                }
            }
            st[t] = true;
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        // 初始化邻接表
        ArrayList<ArrayList<int[]>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        // 读入全部边
        for (int i = 0; i < m; i++) {
            String[] abc = br.readLine().split(" ");
            int a = Integer.parseInt(abc[0]), b = Integer.parseInt(abc[1]), c = Integer.parseInt(abc[2]);
            map.get(a).add(new int[]{b, c});
            map.get(b).add(new int[]{a, c});
        }
        // 读入商店
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int i1 = Integer.parseInt(br.readLine());
            // 为每个商店添加虚拟汇点(源点)
            map.get(0).add(new int[]{i1, 0});
        }
        // 计算从该虚拟点到所有村庄的距离即为商店和村庄之间的最短距离
        int[] djs = djs(0, n, map);
        // 处理询问
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            int q1 = Integer.parseInt(br.readLine());
            System.out.println(djs[q1]);
        }
    }
}
