package 数组链表练习题.双指针技巧.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/permutation-in-string/description/
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class _567_字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        //使用哈希表用于记录 s1 中每个字符出现的次数
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            // c是将移入窗口的字符
            char c = s2.charAt(right);
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧是否要收缩
            while (right - left >= s1.length()){    // s1是s2的子串 滑动窗口其实就是s1 所以是定长的，换成if也没问题
                // 是否找到了合理的子串 直接返回
                if (valid == need.size()){
                    return true;
                }
                // 左侧进行收缩
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return false;

    }
}
