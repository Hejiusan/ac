package hot100.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class _102_二叉树的层序遍历 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)   return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while控制遍历每一层
        while (!q.isEmpty()){
            int sz = q.size();  // 当前层的节点个数
            List<Integer> nodes = new LinkedList<>();
            // for遍历当前层的所有节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();    // 当前节点
                nodes.add(cur.val);
                // 如果当前节点没有子节点了，继续下一个节点
                if (cur.left == null && cur.right == null){
                    continue;
                }

                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            res.add(nodes);
        }
        return res;
    }
}
