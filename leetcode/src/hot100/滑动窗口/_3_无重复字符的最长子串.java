package hot100.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked

    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0 , right = 0;
        while (right < s.length()){
            // 窗口移入一个字符串
            char c = s.charAt(right);
            right++;
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 判断左侧是否要收缩窗口，如果加进来的字符串数量>1
            while (map.get(c) > 1){
                char d = s.charAt(left);
                left++;
                // 移出的字符数量也要-1
                map.put(d, map.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
