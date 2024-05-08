package 二叉树.二叉搜索树BST;

public class 在BST中插入or删除一个数 {
    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点（空的子节点）
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val) // 要插入的值比 root.val大 说明在右子树 递归进去右子树
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root.val == key) {
            // 找到啦，进行删除
            /**
             * 删除分三种情况
             * 1: 节点恰好是末端节点，两个子节点都为空，直接删
             * if (root.left == null && root.right == null)
             *     return null;
             *
             * 2：节点只有一个非空节点，那么让他的子节点来接替位置
             * if (root.left == null) return root.right;
             * if (root.right == null) return root.left;
             * 1 2 可以合并
             *
             * 3：有两个子节点，需保证不破坏BST的性质 因此必须找到左子树中最大的那个节点，或者 右子树中最小的那个节点来接替自己
             */
            if (root.left == null) return root.right;   //
            if (root.right == null) return root.left;
            // 处理情况 3
            // 获得右子树最小的节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            // 去左子树找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 去右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }

}
