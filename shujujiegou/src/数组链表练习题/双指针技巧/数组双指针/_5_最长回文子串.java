package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

    思路
     for 0 <= i < len(s):
         找到以 s[i] 为中心的回文串
         找到以 s[i] 和 s[i+1] 为中心的回文串
         更新答案
 */
public class _5_最长回文子串 {
    // 找回文串需要从中间向两边发散  考虑长度为奇数还是偶数
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
     * @param s
     * @param l
     * @param r
     * @return
     * 如果l和r相同，就表示寻找长度为奇数的回文串
     * 如果是相邻的l和r，表示为偶数的回文串
     */
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);  // 左开右闭
    }

}
