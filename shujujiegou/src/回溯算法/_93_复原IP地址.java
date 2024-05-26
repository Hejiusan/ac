package 回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class _93_复原IP地址 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res; // 如果字符串长度不合适，直接返回空结果
        }
        backTracking(s, 0, 0, "");
        return res;
    }

    /**
     *
     * @param s
     * @param pointNum：插入的点的数量
     * @param start：记录开始索引，防止重复使用
     */
    private void backTracking(String s, int pointNum, int start, String currentIp) {
        // 结束条件
        if (pointNum == 4 && start == s.length()){
            res.add(currentIp.substring(0, currentIp.length() - 1));    //去掉最后一个"."
            return;
        }
        // 剪枝
        if (pointNum == 4 || start == s.length()){
            return;
        }
        //一个段一个段的找，每段最多3个数
        for (int i = 1; i < 4; i++) {
            // 剪纸
            if (start + i > s.length()) {
                break;
            }
            String part = s.substring(start, start + i);
            if (isValid(part)){//找到一个合理的段
                pointNum++;
                backTracking(s, pointNum, start + i, currentIp + part+".");
                // 撤销
                pointNum--;
            }

        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) {
            return false; // 前导0无效
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

}
