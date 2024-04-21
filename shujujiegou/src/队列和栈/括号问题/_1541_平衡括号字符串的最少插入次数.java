package 队列和栈.括号问题;

/**
 * https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/description/
 *
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * 请你返回让 s 平衡的最少插入次数。
 */
public class _1541_平衡括号字符串的最少插入次数 {
    public int minInsertions(String s) {
        int need = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '('){
                need += 2;
                if (need %2 == 1){  // 说明还得补一个右括号
                    res++;
                    need--;
                }
            }
            if (c == ')') {
                need--;
                if (need == -1) {   // 遇到一个多余的右括号了
                    res++;  //补一个左括号
                    need = 1;   // 因为是多了一个右括号补了一个左括号；一对二 所以还需要一个右括号
                }
            }
        }
        return res + need;
    }
}
