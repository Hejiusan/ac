package 数组链表练习题.双指针技巧.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/description/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        // 用于记录需要的字符和窗口中的字符及其出现的次数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 统计 t 中各字符出现次数
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);   // 记录需要的字符串

        int left = 0, right = 0;
        int valid = 0; // 窗口中满足需要的字符个数  需要的某个字符满足要求了就+1
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {    // 右边扩大、左边收缩来控制窗口大小
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++; // 只有当 window[c] 和 need[c] 对应的出现次数一致时，才能满足条件，valid 才能 +1
            }

            // 判断左侧窗口是否要收缩
            // 已经找到一个子串可以覆盖掉所需的字符了，在判断下是否可以进一步缩小
            while (valid == need.size()) {  // need.size()就是总共需要的字符的种类, 可能有重复的字符所以个数不止1
                // 更新最小覆盖子串     先更新最小覆盖子串的长度，在收缩，看后面有没有更小的
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {  // 如果被移除的是所需要的字符，valid--
                    if (window.get(d).equals(need.get(d)))
                        valid--; // 只有当 window[d] 内的出现次数和 need[d] 相等时，才能 -1
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }
}
