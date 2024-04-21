package 数组链表练习题.双指针技巧.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法框架
 */
public class Main {
    /* 滑动窗口算法框架 */
    public static void slidingWindow(String s) {
        // 用合适的数据结构记录窗口中的数据，根据具体场景变通
        // 比如说，我想记录窗口中元素出现的次数，就用 map
        // 我想记录窗口中的元素和，就用 int
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        // 开始右扩，加入窗口
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
            // ...

            /*** debug 输出的位置 ***/
            // 注意在最终的解法代码中不要 print
            // 因为 IO 操作很耗时，可能导致超时
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

            // 判断左侧窗口是否要收缩
            while (left < right && window needs shrink) {   // 这里的判断条件要根据问题来
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                // ...
            }
        }
    }

    public static void main(String[] args) {
        slidingWindow("your string here");
    }
}
