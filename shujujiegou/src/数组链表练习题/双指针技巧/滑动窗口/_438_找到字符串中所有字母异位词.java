package 数组链表练习题.双指针技巧.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 相当于，输入一个串 S，一个串 T，找到 S 中所有 T 的排列，返回它们的起始索引。
 * 示例：
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class _438_找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        // 开始右扩，加入窗口
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                // 需要的加进去
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否左侧收缩
            while (right - left >= p.length()) {
                if (valid == need.size()){
                    res.add(left);
                }
                char d = s.charAt(left);    //移除的字符
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }
}
