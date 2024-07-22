package hot100.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class _22_括号生成 {
    /*
    理解题目：n对括号，==》2n个字符
    现在有 2n 个位置，每个位置可以放置字符 ( 或者 )，组成的所有括号组合中，有多少个是合法的？
    暴力穷举需要剪枝
        1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解。
        2、对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
     */
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 回溯过程中的路径
        StringBuilder path = new StringBuilder();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, path);
        return res;
    }

    /**
     * 回溯
     * @param left：需要的左括号数量
     * @param right：需要的右括号数量
     * @param path
     */
    private void backtrack(int left, int right, StringBuilder path) {
        // 剪枝
        // 若左括号剩下的多，说明不合法
        if (right < left)
            return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0)
            return;

        // 终止条件
        if (left == 0 && right == 0){
            res.add(path.toString());
            return;
        }

        // 尝试放一个左括号
        path.append("(");
        backtrack(left-1, right, path);
        path.deleteCharAt(path.length() - 1);   // 撤销选择

        // 尝试放一个右括号
        path.append(")");
        backtrack(left,right-1, path);
        path.deleteCharAt(path.length() - 1);
    }
}
