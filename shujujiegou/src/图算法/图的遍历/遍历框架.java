package 图算法.图的遍历;

/**
 * 图和多叉树最大的区别是，图是可能包含环的，你从图的某一个节点开始遍历，有可能走了一圈又回到这个节点，
 * 而树不会出现这种情况，从某个节点出发必然走到叶子节点，绝不可能回到它自身。
 * 所以图的遍历需要一个 visited[]来记录是否被访问过
 */
public class 遍历框架 {

    // 记录被遍历过的节点
    boolean[] visited;
    // 记录从起点到当前节点的路径
    boolean[] onPath;   // 常用于判断图中是否有环

    /* 图遍历框架 */
    void traverse(Graph graph, int s) {
        if (visited[s]) return;
        // 经过节点 s，标记为已遍历
        visited[s] = true;
        // 做选择：标记节点 s 在路径上
        onPath[s] = true;
        for (int neighbor : graph.neighbors(s)) {
            traverse(graph, neighbor);
        }
        // 撤销选择：节点 s 离开路径
        onPath[s] = false;
    }


}
