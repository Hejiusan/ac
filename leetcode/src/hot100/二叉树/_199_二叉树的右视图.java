package hot100.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 */
public class _199_二叉树的右视图 {
    List<Integer> res = new ArrayList<>();
    /*
    本质就是广度优先搜索找每一层最右边的那个节点
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)   return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int sz = q.size();
            // 遍历当前层的所有节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 当前层的最后一个节点，加入res
                if (i == sz - 1)
                    res.add(cur.val);

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

        }
        return res;
    }


}
