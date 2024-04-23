package 数据结构设计.LRU算法;

import java.util.LinkedHashMap;

/**
 * LRU(Least Recently Used) 算法就是一种缓存淘汰策略
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 也就是要满足以下要求：
 * 1、 cache 中的元素必须有时序，以区分最近使用的和久未使用的数据，当容量满了之后要删除最久未使用的那个元素腾位置。
 * 2、我们要在 cache 中快速找某个 key 是否已存在并得到对应的 val；
 * 3、每次访问 cache 中的某个 key，需要将这个元素变为最近使用的，也就是说 cache 要支持在任意位置快速插入和删除元素。
 *
 * 哈希链表 LinkedHashMap 双向链表和哈希表的结合体 完美满足
 */
public class _146_LRU缓存 {
    static class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        /**
         * 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
         * @param key
         * @param val
         */
        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, val);    // LinkedHashMap自带的插入方法
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap) { // 当容量满了之后要删除最久未使用的那个元素腾位置。
                // 链表头部就是最久未使用的 key
                // keyset():返回所有的key 组成的 Set 视图（去重key）。
                // iterator()迭代器：初始指向元素的上方的空，再.next：指针下移，返回该指针所指向的元素；也就是第一个元素
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除 key，重新插入到队尾   // 靠近尾部的数据是最近使用的，靠头部的数据是最久未使用的
            cache.remove(key);
            cache.put(key, val);
        }
    }


}
