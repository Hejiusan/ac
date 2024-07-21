package 图算法.图的遍历;

import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1179
 * <p>
 * 给定一个包含 n 个节点的无向图中，节点编号从 1 到 n （含 1 和 n ）。
 * 你的任务是判断是否有一条从节点 source 出发到节点 destination 的路径存在。
 */
public class _107_寻找存在的路径 {
    /**
     * 使用了并查集（Union-Find）来判断图中两个节点是否连通
     */
    static int[] father;

    // 并查集中找到元素的根节点
    public static int find(int u) {
        if (father[u] != u) {
            father[u] = find(father[u]); // 路径压缩
        }
        return father[u];
    }
    static boolean isSame(int u, int v){
        return find(u) == find(v);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 节点的个数
        int m = sc.nextInt();   // 边的个数
        father = new int[n + 1];   //存储每个元素的父节点
        // 并查集初始化
        for (int i = 1; i<=n; i++)  father[i] = i;   //初始化

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            father[find(a)] = find(b);    //合并集合，将a的祖宗的父节点等于b的祖宗
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();
        // 输出结果，如果 source 和 destination 是连通的，则输出 1，否则输出 0
        System.out.println(isSame(source, destination) ? 1 : 0);
        sc.close();
    }
}
