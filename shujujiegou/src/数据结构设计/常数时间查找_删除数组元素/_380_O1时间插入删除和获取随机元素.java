package 数据结构设计.常数时间查找_删除数组元素;

import java.util.*;

/**
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/description/
 *
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * 因为只有数组根据索引取值，才能保证O(1)的复杂度；也意味着需要通过数组实现O(1)进行插入删除操作
 * 思路：将要删除的值移到尾部 pop掉
 */
public class _380_O1时间插入删除和获取随机元素 {
    class RandomizedSet {

        // 存储元素的值
        List<Integer> nums;
        // 记录每个元素对应在 nums 中的索引
        Map<Integer, Integer> valToIndex;


        public RandomizedSet() {
            nums = new ArrayList<>();
            valToIndex = new HashMap<>();
        }

        public boolean insert(int val) {
            // 若 val 已存在，不用再插入
            if (valToIndex.containsKey(val)) {
                return false;
            }
            // 若 val 不存在，插入到 nums 尾部，
            // 并记录 val 对应的索引值
            valToIndex.put(val, nums.size());   // 数组索引是要-1的 所以这里先存索引在size++
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)){
                return false;
            }
            int idx = valToIndex.get(val);  // 要删除的索引
            // 将最后一个元素的索引修改为 idx    这一步也就是让最后一个元素 来代替被删除掉的这个元素的 继承他的索引
            valToIndex.put(nums.get(nums.size() - 1), idx);
            // 交换 val 和最后一个元素 这里是交换元素值
            Collections.swap(nums, idx, nums.size() - 1);
            // 索引和元素值 是独立维护的
            // 在数组中删除元素 val
            nums.remove(nums.size() - 1);
            // 删除元素 val 对应的索引
            valToIndex.remove(val);
            return true;
        }

        /**
         * 随机返回一个值且是O(1)复杂度，那只能是数组根据随机索引直接取值
         * valToIndex 单独维护索引，根据索引来实现O(1)复杂度取值
         * @return
         */
        public int getRandom() {
            // 随机获取 nums 中的一个元素
            // (int)(Math.random()*2+1) 取随机 0~3（娶不到3）的数  这里就是随机取 0~size-1的数  size娶不到
            return nums.get((int)(Math.random() * nums.size()));
        }
    }
}
