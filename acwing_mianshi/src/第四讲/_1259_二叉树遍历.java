package 第四讲;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1261/
 * <p>
 * 树和二叉树基本上都有先序、中序、后序、按层遍历等遍历顺序，给定中序和其它一种遍历的序列就可以确定一棵二叉树的结构。
 * <p>
 * 假定一棵二叉树一个结点用一个字符描述，现在给出中序和按层遍历的字符串，求该树的先序遍历字符串。
 * <p>
 * 输入格式
 * 两行，每行是由大写字母组成的字符串（一行的每个字符都是唯一的），分别表示二叉树的中序遍历和按层遍历的序列。
 * <p>
 * 输出格式
 * 一行，表示二叉树的先序序列。
 */
public class _1259_二叉树遍历 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();  // 中序遍历
        String s2 = sc.nextLine();  // 层序遍历

        HashMap<Character, Integer> valToIndex = new HashMap<>();   // 哈希表存每个点中序遍历的位置
        ArrayDeque<TreeNode> deque = new ArrayDeque<>(s1.length());
        TreeNode root = new TreeNode(s2.charAt(0));   // 根节点
        deque.add(root);

        boolean[] st = new boolean[26]; // 标记某个点是否被用过

        for (int i = 0; i < s1.length(); i++) {
            valToIndex.put(s1.charAt(i), i);
        }
        
        // 按层遍历， i 是当前层的起点，j是下一层的起点
        for (int i = 0, j = 1; j < s2.length();) {
            for (int end = j; i < end; i++) {   // 遍历当前层
                TreeNode node = deque.poll();

                int p = valToIndex.get(s2.charAt(i));    // 先获取当前节点的位置
                st[p] = true;   // 标记用过了当前节点
                // 判断左儿子是否存在:  p 一定 >0 并且 p-1 的位置没有被用过
                if (p > 0 && !st[p-1]){
                    node.left = new TreeNode(s2.charAt(j));
                    j++;
                    deque.add(node.left);
                }
                if (p+1 < s2.length() && !st[p+1]){
                    node.right = new TreeNode(s2.charAt(j));
                    deque.add(node.right);
                    j++;
                }
            }
        }




        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        System.out.println(sb);


    }

    public static void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(char val) {
            this.val = val;
        }

        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
