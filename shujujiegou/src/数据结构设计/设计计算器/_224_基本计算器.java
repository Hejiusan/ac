package 数据结构设计.设计计算器;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/basic-calculator/description/
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 */
public class _224_基本计算器 {
    public int calculate(String s) {
        Queue<Character> queueS = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queueS.add(c);
        }

        return helper(queueS);
    }

    private int helper(Queue<Character> s) {
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int num = 0;

        while (!s.isEmpty()) {
            char c = s.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + Character.getNumericValue(c);
            }
            // 遇到左括号开始递归计算 num
            if (c == '(') {
                num = helper(s);
            }

            if ((!Character.isDigit(c) && c != ' ') || s.isEmpty()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
            // 遇到右括号返回递归结果
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }

}
