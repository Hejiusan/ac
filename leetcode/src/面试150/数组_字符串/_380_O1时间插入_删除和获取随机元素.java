package 面试150.数组_字符串;

import java.util.*;

/**
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 实现RandomizedSet 类：实现一个set
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
public class _380_O1时间插入_删除和获取随机元素 {
    class RandomizedSet {
        // 存储元素的值
        List<Integer> nums;
        // 记录每个元素对应在 nums 中的索引
        Map<Integer, Integer> valToIndex;

        public RandomizedSet() {
            nums = new ArrayList<>();
            valToIndex = new HashMap<>();
        }

        /**
         * 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
         * @param val
         * @return
         */
        public boolean insert(int val) {
            if (valToIndex.containsKey(val)){
                return false;
            }
            // val添加到末尾，因为索引是要减一的，所以先存索引，在size++
            valToIndex.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /**
         * 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
         * 要求在o1的时间复杂度内，所以可以将要删除的元素移到末尾去删
         * @param val
         * @return
         */
        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)){
                return false;
            }
            Integer idx = valToIndex.get(val);  // 要删除的元素的索引
            valToIndex.put(nums.get(nums.size() - 1), idx); // 将末尾元素的索引和要删除的元素的索引交换
            // 交换完索引在交换值
            Collections.swap(nums, idx, nums.size() - 1);
            nums.remove(nums.size() - 1);       // 删除末尾元素
            valToIndex.remove(val);     // 删除索引映射
            return true;
        }

        /**
         * 随机返回现有集合中的一项  o1时间复杂度, 那只能是索引映射valtoIndex随机取值
         * @return
         */
        public int getRandom() {
            // (int)(Math.random()*2+1) 取随机 0~3（娶不到3）的数  这里就是随机取 0~size-1的数  size娶不到
            return nums.get((int)(Math.random() * nums.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
