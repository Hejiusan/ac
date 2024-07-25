package hot100.栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class _394_字符串解码 {
    public String decodeString(String s) {
        //
        Stack<Integer> counts = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String result = "";
        int index = 0;

        while (index < s.length()) {
            char currentChar = s.charAt(index);
            if (Character.isDigit(currentChar)) {
                // 遇到数字时，可能是多位数，所以要循环读取直到非数字为止，将它转换成整数存入 counts 栈。
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    // s.charAt(index) - '0' 将0~9的数字字符转为数字
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (currentChar == '[') {
                // 遇到 ‘[’ 时，意味着要开始一个新的重复字符串序列，此时将当前的 result 推入栈 resultStack，并重置 result 为新的空字符串。
                resultStack.push(result);
                result = "";
                index++;
            } else if (currentChar == ']') {
                // 遇到 ‘]’ 时，从 counts 栈中弹出顶部元素（即重复次数），
                // 从 resultStack 中弹出之前保存的结果字符串，然后将当前 result 字符串重复指定次数，并拼接到之前保存的结果字符串上。
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int repeatTimes = counts.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(result);
                }
                result = temp.toString();
                index++;
            } else {
                // 遇到字母了，直接将字母追加到当前 result 字符串。
                result += currentChar;
                index++;
            }
        }
        return result;
    }
}
