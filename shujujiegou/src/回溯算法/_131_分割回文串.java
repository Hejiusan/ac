package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串
 *  。返回 s 所有可能的分割方案。
 */
public class _131_分割回文串 {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        LinkedList<String> path = new LinkedList<>();
        Backtracking(s, 0, path);
        return res;
    }

    private void Backtracking(String s, int start, LinkedList<String> path) {
        // 结束条件
        if (start == s.length()){
            res.add(new LinkedList<>(path));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)){
                path.add(s.substring(start, i+1));  // 左闭又开
                Backtracking(s, i+1, path);
                path.removeLast();
            }
        }
    }

    /**
     * 判断是否为回文
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
