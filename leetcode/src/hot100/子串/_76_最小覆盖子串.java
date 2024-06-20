package hot100.子串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        // 所有需要的字符
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        // 从最左侧开始，把满足条件的字符添加进去
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                // 加入窗口
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            // 如果已经满足条件
            while (valid == need.size()){
                // 更新最短长度
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                // 判断左侧是否要收缩
                char left_c = s.charAt(left);
                left_c++;
                // 更新窗口里的值以及判断是否还满足need
                if (need.containsKey(left_c)){  // 移除的刚好是需要的
                    if (window.get(left_c).equals(need.get(left_c))){
                        valid--;
                    }
                    window.put(left_c, window.get(left_c)-1);
                }

            }
        }
        return len == Integer.MAX_VALUE? "" : s.substring(start, start+len);
    }
}
