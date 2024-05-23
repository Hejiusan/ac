package hot100.哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class _49_字母异位词分组 {
    //编码 -》 分组 映射
    HashMap<String, List<String>> codeToGroup = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String str : strs) {
            String code = encode(str);
            // 把编码相同的字符串放在一起
            // putIfAbsent 和put方法一样，都是添加键值对 到HashMap中
            // 如果存在添加的键，put会覆盖掉旧值，而putIfAbsent不会替换掉旧值
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(str); // 旧值还保留，继续add进新的value
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : codeToGroup.values()) {
            res.add(value);
        }
        return res;
    }

    // 利用每个字符的出现次数进行编码
    String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return new String(count);
    }
}
