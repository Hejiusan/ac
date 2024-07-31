package hot100.动态规划;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
 */
public class _32_最长有效括号 {
    /*
        栈和动态规划
        dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        转移方程：
            一个合理的括号就是（）所以他可以有左括号之前的dp[leftIndex] + 新的左右括号长度 转移而来
            dp[i+1] = dp[leftIndex] + (i - leftIndex + 1)
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>(); // 注意存的是索引
        int []dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){    // 遇到左括号就入栈
                stk.push(i);
                dp[i+1] = 0;    // 初始化 因为以左括号结尾的子串不可能是有效的括号子串
            }else {
                // 遇到右括号了，去和栈顶元素匹配
                if (!stk.isEmpty()){
                    // stk不为空说明里面有左括号
                    int leftIndex = stk.pop();  //配对的左括号索引
                    // 当i处是右括号且能匹配栈中的左括号。
                    int len = dp[leftIndex] + ( i - leftIndex ) + 1;    // 更新长度
                    dp[i+1] = len;
                }else { // 栈为空，说明了遇到右括号时，之前没有左括号，不合法了 直接清零
                    dp[i+1] = 0;
                }
            }
        }
        // 计算最长子串的长度
        int res = 0;
        for (int j : dp) {   // 和 以每一个索引结尾的最大长度比较，取最大值
            res = Math.max(res, j);
        }
        return res;
    }


    /*
    也可以简化代码，不使用辅助栈
     */
    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // Case: ...()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // Case: ...))
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }
}
