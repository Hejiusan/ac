package 二叉树.遍历;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 简单的遍历会有问题，相邻两颗子树之间无法通过next指针连起来，；
 * 通过抽象成三叉树来解决
 */
public class _116_填充每个节点的下一个右侧节点指针 {
    // 主函数
    Node connect(Node root) {
        if (root == null) return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架

    /**
     * 每个「三叉树节点」需要做的事就是把自己内部的两个二叉树节点穿起来：
     * @param node1
     * @param node2
     */
    void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        node1.next = node2;

        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点 // 相邻两颗子树的间隔节点穿起来
        traverse(node1.right, node2.left);
    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}

