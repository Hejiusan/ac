package hot100.回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串. 返回 s 所有可能的分割方案。
 */
public class _131_分割回文串 {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
        LinkedList<String> path = new LinkedList<>();
        traverse(s, path, 0);
        return res;
    }

    private void traverse(String s, LinkedList<String> path, int start) {
        // 结束条件
        if (start == s.length()){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)){
                path.add(s.substring(start, i+1));
                traverse(s, path, i+1);
                path.removeLast();
            }
        }
    }
    // 判断是否回文串
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


}
