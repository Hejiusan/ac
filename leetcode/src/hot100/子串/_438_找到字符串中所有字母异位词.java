package hot100.子串;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class _438_找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 找到p的每个字符就是一组有效的异味词
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口在找满足need的情况
        int left = 0,right = 0;
        int valid = 0;  // 记录单个字符是否满足情况了
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))) {    // 满足了该字符
                    valid++;
                }
            }
            // 判断左侧是否要收缩
            if (right - left >= p.length()){    // 窗口大于p的长度了，需要收缩
                if (valid == need.size()){
                    res.add(left);  // 满足条件了，存开始索引
                }
                // 收缩移除左侧字符
                char left_c = s.charAt(left);
                left++;
                // 如果恰好他是需要的字符，也要移除
                if (need.containsKey(left_c)) {
                    if (window.get(left_c).equals(need.get(left_c))) {
                        valid--;
                    }
                    window.put(left_c, window.get(left_c) - 1);
                }

            }
        }
        return res;

    }
}
