package 图算法.图的遍历;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/all-paths-from-source-to-target/description/
 *
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 */
public class _797_所有可能的路径 {

    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 维护递归过程中经过的路径
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.add(s);
        // 注意 这里要加个结束条件
        if (s == graph.length - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
        }
        // 访问s的邻接点
        for (int i : graph[s]) {
            traverse(graph, i, path);
        }

        // 从路径移出节点 s    撤销选择
        path.removeLast();  // 和树的遍历不同，图遍历 撤销选择要放在循环外，不然会漏掉根节点
    }
}
