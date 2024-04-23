package 数组链表练习题.双指针技巧.数组双指针;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/remove-duplicate-letters/description/
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的
 * 字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 要求一、要去重。
 * 要求二、去重字符串中的字符顺序不能打乱 s 中字符出现的相对顺序。
 * 要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。
 *
 * 思路：
 * 要利用 stack 结构和一个 inStack 布尔数组来满足上述三个条件，具体思路如下：
 * 通过 inStack 这个布尔数组做到栈 stk 中不存在重复元素，满足要求一。
 * 我们顺序遍历字符串 s，通过「栈」这种顺序结构的 push/pop 操作记录结果字符串，保证了字符出现的顺序和 s 中出现的顺序一致，满足要求二。
 * 我们用类似单调栈的思路，配合计数器 count 不断 pop 掉不符合最小字典序的字符，保证了最终得到的结果字典序最小，满足要求三。
 */
public class _316_去除重复字母 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (inStack[c]) continue;

            while (!stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
