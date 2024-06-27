package 二叉树.遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null)   return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);  // 将起点加入队列
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()){
            int sz = q.size();  // 当前层的节点数
            /* 将当前队列中的所有节点向四周扩散 */
            // 遍历当前层的所有节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                // 如果是叶子节点，返回当前深度, 如果有子节点 就加入队列，在下次while 中作为下一层的节点继续
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);

            }
            depth++;
        }
        return depth;
    }
}

