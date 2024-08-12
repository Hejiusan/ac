package 第四讲;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1261/
 *
 * 树和二叉树基本上都有先序、中序、后序、按层遍历等遍历顺序，给定中序和其它一种遍历的序列就可以确定一棵二叉树的结构。
 *
 * 假定一棵二叉树一个结点用一个字符描述，现在给出中序和按层遍历的字符串，求该树的先序遍历字符串。
 *
 * 输入格式
 * 两行，每行是由大写字母组成的字符串（一行的每个字符都是唯一的），分别表示二叉树的中序遍历和按层遍历的序列。
 *
 * 输出格式
 * 一行，表示二叉树的先序序列。
 */
public class _1259_二叉树遍历 {

    public static void main(String[] args) {
        HashMap<Character, Integer> valToIndex = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();  // 中序遍历
        String s2 = sc.nextLine();  // 层序遍历
        char root = s2.charAt(0);   // 根节点
        for (int i = 0; i < s1.length(); i++) {
            valToIndex.put(s1.charAt(i),i);
        }


    }
}
