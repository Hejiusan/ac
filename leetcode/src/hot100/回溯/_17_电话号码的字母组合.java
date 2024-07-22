package hot100.回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class _17_电话号码的字母组合 {
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return res;
        }
        traverse(digits, 0);
        return res;
    }

    private void traverse(String digits, int startIndex) {
        // 结束条件
        if (sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(startIndex) - '0';    // 将字符串里的数字转为int类型
        // 遍历该数字对应的字符
        for (char c : mapping[digit].toCharArray()) {
            sb.append(c);   // 添加一个进去
            // 回溯下一个选择
            traverse(digits, startIndex + 1);
            // 撤销选择
            sb.deleteCharAt(sb.length() - 1);   // 撤销掉最后那个加进去的字符
        }

    }
}
