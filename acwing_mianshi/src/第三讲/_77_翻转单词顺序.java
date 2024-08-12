package 第三讲;

/**
 * https://www.acwing.com/problem/content/73/
 *
 * 输入一个英文句子，单词之间用一个空格隔开，且句首和句尾没有多余空格。翻转句子中单词的顺序，但单词内字符的顺序不变。
 *
 * 为简单起见，标点符号和普通字母一样处理。
 *
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class _77_翻转单词顺序 {
    public String reverseWords(String s) {
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--) {
            sb.append(sp[i]);
            if (i!=0)   sb.append(" ");
        }
        return sb.toString();
    }
}
