package hot100.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked

    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            while (window.get(c) > 1) {  // 窗口存在重复值，收缩
                // 最左侧值移出窗口  对应的出现次数也得减1
                char left_s = s.charAt(left);
                window.put(left_s, window.get(left_s) - 1);
                left++;
            }
            // 更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
