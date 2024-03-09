package 数组链表练习题.双指针技巧.数组双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */

public class _03_最长不重复子串 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        // 双指针
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            // 注意这里要用whilie循环  比如出现pwwkew时，if判断会导致去掉了p 而ww还存在，且无法判断
            while (window.get(c) > 1){
                // 最左侧值移除窗口  对应的出现次数也得减1
                char left_s = s.charAt(left);
                window.put(left_s, window.get(left_s) - 1);
                left++;
            }
            // 更新答案
            res = Math.max(res, right- left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
