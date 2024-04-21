package 队列和栈.括号问题;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/description/?show=1
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class _32_最长有效括号 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        int[] dp = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stk.push(i);
                dp[i+1] = 0;
            }else {
                // 遇到右括号
                if (!stk.isEmpty()){
                    // 有一个左括号了，进行配对, 表示合法
                    int leftIndex = stk.pop();  //配对的左括号索引
                    int len = dp[leftIndex] + ( i - leftIndex ) + 1;    // 更新长度
                    dp[i+1] = len;
                }else{  // 左括号之后没遇到右括号 直接清零
                    dp[i+1] = 0;
                }
            }
        }
        // 计算最长子串的长度
        int res = 0;
        for (int i = 0; i < dp.length; i++) {   // 和 以每一个索引结尾的最大长度比较，取最大值
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
