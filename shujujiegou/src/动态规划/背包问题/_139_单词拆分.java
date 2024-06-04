package 动态规划.背包问题;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-break/description/
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class _139_单词拆分 {
    /*
    单词就是物品，字符串s就是背包，单词能否组成字符串s，就是问物品能不能把背包装满。
    dp[i] 表示字符串 s 的前 i 个字符是否可以由字典中的单词拼接而成。
    状态转移方程：
	    对于每个 i（从 1 到 s.length()），遍历 j（从 0 到 i-1），如果 dp[j] 为 true，
	    并且 s.substring(j, i) 在 wordDict 中，那么 dp[i] 为 true。
    转移方程：dp[j] && wordSet.contains(s.substring(j, i))
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // 将 wordDict 转换为 Set 提高查找效率
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // 初始化 dp[0]
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // 只要找到一个符合条件的分割点，就可以确定 dp[i] 为 true
                }
            }
        }
        return dp[s.length()];
    }
}
