package 队列和栈.括号问题;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class _1047_删除字符串中的所有相邻重复项 {
    Stack<Character> st = new Stack<>();
    public String removeDuplicates(String s) {
        for (char c : s.toCharArray()) {
            if (st.isEmpty() || c != st.peek()){
                st.push(c);
            }else {
                st.pop();   // 新入栈的元素和栈顶元素重了，删除掉
            }
        }
        String res = "";
        while (!st.isEmpty()){
            res+=st.pop();
        }
        // 然后需要翻转一下元素顺序
        return new StringBuffer(res).reverse().toString();
    }
}
