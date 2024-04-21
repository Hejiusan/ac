package 队列和栈.括号问题;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/description/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 思路：
 * 遇到左括号就入栈，遇到右括号就去栈中寻找最近的左括号，看是否匹配。
 */
public class _20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='('||c=='{'||c=='['){
                left.push(c);
            }else { // 右括号必须和左括号匹配
                if (!left.isEmpty() && checkRight(c) == left.peek()){   //peek（）是返回栈顶元素，但不会弹出
                    left.pop();
                }else
                    return false;
            }
        }
        // 是否所有的左括号都被匹配了
        return left.isEmpty();
    }

    private Character checkRight(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}
