package 队列和栈.括号问题;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
 *
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 (向下取整)
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class _150_逆波兰表达式求值 {
    /*
    其实逆波兰表达式相当于是二叉树中的后序遍历。 运算符是中间节点（根节点）
    这里和_1047_删除字符串中的所有相邻重复项相似，只是这里不是删除
    而是遇到运算符时，将相邻两元素进行运算
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int num1 = st.pop();
                int num2 = st.pop();
                if (token.equals("+"))  st.push(num1+num2);
                if (token.equals("-"))  st.push(num2-num1); // 注意出栈顺序
                if (token.equals("*"))  st.push(num1*num2);
                if (token.equals("/"))  st.push(num2/num1);// 注意出栈顺序
            }else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

}
