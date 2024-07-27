package hot100.堆;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class _763_划分字母区间 {
    /*
        统计每一个字符最后出现的位置
        从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
     */
    public List<Integer> partitionLabels(String s) {
        int hash[] = new int[27]; // i为字符，hash[i]为字符出现的最后位置
        for (int i = 0; i < s.length(); i++) { // 统计每一个字符最后出现的位置
            hash[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']); // 找到字符出现的最远边界
            // 字符最远出现位置下标和当前下标相等  意味着找到了分割点
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;

    }

}
