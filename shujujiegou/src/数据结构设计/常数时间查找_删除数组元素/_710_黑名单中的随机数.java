package 数据结构设计.常数时间查找_删除数组元素;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/random-pick-with-blacklist/description/
 * <p>
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
 * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 * <p>
 * 思路：
 * 1、如果想高效地，等概率地随机获取元素，就要使用数组作为底层容器。
 * 2、如果既要保持数组元素的紧凑性，又想从数组中间删除元素，那么可以把待删除元素换到最后，
 * 然后 pop 掉末尾的元素，这样时间复杂度就是 O(1) 了。当然，这样做的代价是我们需要额外的哈希表记录值到索引的映射。
 */
public class _710_黑名单中的随机数 {

    class Solution {
        int sz;
        Map<Integer, Integer> mapping;  // 记录索引映射

        public Solution(int n, int[] blacklist) {
            sz = n - blacklist.length;  // 不在黑名单的数字个数
            mapping = new HashMap<>();

            for (int b : blacklist) {
                mapping.put(b, 666); // 标记黑名单
            }

            int last = n - 1;
            for (int b : blacklist) {
                // 如果 b 已经在区间 [sz, N)，可以直接忽略
                if (b >= sz) {  // 表示黑名单上的数字已经在末尾了
                    continue;
                }
                // 把黑名单里的数移到最末尾 如果尾部已经是黑名单了 就last--
                while (mapping.containsKey(last)) { // 找到可以映射的位置
                    last--;
                }
                mapping.put(b, last); // 映射 也相当于是交换了索引映射
                last--;
            }
        }

        public int pick() {
            // 随机选取一个索引
            int index = (int)(Math.random() * sz);  // 0~sz 的随机数 这里就是未在黑名单的数字
            // 这个索引命中了黑名单，需要被映射到其他位置
            // 因为索引的值和元素的值是一样的，但是现在元素其实被移到了尾部，所以不能直接return索引，而是找到给他映射到尾部的索引位置
            if (mapping.containsKey(index)) {
                return mapping.get(index);
            }
            // 若没命中黑名单，则直接返回
            return index;
        }
    }
}
