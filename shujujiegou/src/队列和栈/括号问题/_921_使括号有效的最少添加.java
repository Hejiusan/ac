package 队列和栈.括号问题;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/description/
 *
 * 只有满足下面几点之一，括号字符串才是有效的：
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号
 *
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 *
 * 思路：
 * 核心思路是以左括号为基准，通过维护对右括号的需求数 need，来计算最小的插入次数。
 */
public class _921_使括号有效的最少添加 {
    public static int minAddToMakeValid(String s) {
        int res = 0;
        int need = 0;
        for (char c : s.toCharArray()) {
            if (c=='('){
                need++;
            }
            if (c == ')') {
                need--;
                if (need<0){
                    res++;  // 需要补一个左括号
                    need=0;
                }
            }

        }
        //因为res记录的左括号的插入次数，need记录了右括号的需求，当for循环结束后，若need不为0,那么就意味着右括号还不够，需要插入。
        return need+res;
    }


    public static void main(String[] args) {
        String s = "())";
        int res = minAddToMakeValid(s);
        System.out.println(res);
    }
}
