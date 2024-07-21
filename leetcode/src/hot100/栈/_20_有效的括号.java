package hot100.栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class _20_有效的括号 {
    Stack<Character> st = new Stack<>();
    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '['){
                st.push(c);
            }else { // c是右括号
                // 括号成功匹配 弹出去
                if (!st.isEmpty() && st.peek() == stackOf(c)){
                    st.pop();
                }else {
                    return false;
                }
            }

        }
        // st是空的表示全部匹配完了 都是合法的
        return st.isEmpty();
    }
    static char stackOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}
