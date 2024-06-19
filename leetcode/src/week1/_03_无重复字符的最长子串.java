package week1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class _03_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0, right = 0;
        // 存储窗口字符
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0) + 1);
            right++;
            while (map.get(c) > 1){
                // 出现重复字符了，只能收缩左边
                char c_left = s.charAt(left);
                map.put(c_left, map.get(c_left) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
