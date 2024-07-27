package 第二讲;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1455/
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意：
 *
 * 空字符串被视为0。如果结果中包含前导零，则需要将前导零删除，最后删除的前导零不用包含在移除的 k个数字中。
 */
public class _1453_移掉K位数字 {
    /*
      维护一个单调栈，从底部到栈顶 单调递增。当遇到小的，就移除掉大的。
     */


    public static void main(String[] args) {
        Deque<Character> stack = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int k = sc.nextInt();
        //
        for (char digit : num.toCharArray()) {
            // 当栈不空且栈顶元素大于当前元素且还需移除的数字数量大于0时
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                // 遇到小的就移除掉较大的高位数字
                // 这里应用到了贪心的思想 只要遇到逆序就删除掉大的的
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        // if k >0 还需要移除掉更多数字
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        // 构建最终结果，移除前导零
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char current = stack.removeLast();
            if (leadingZero && current == '0') {
                continue;
            }
            leadingZero = false;
            result.append(current);
        }

        // 如果结果为空，返回"0"
        if (result.length() == 0){
            System.out.println("0");
        }else System.out.println(result.toString());
    }
}
