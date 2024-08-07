package hot100.链表;

import java.util.LinkedHashMap;

/**
 * https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class _146_LRU缓存 {

    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        // 实例化
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key))
                return -1;
            makeRecently(key);
            return cache.get(key);
        }

        /**
         * 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            if (cache.containsKey(key)){
                // 修改key的val值
                cache.put(key, value);
                makeRecently(key);  // 变为最近使用
                return;     // 这里要return出去，不然可能会put两次
            }
            // 如果容量满了，往里put需要移除最近最久未使用，也就是链表头部
            if (cache.size() >= this.cap){
                // API:
                // keyset():返回所有的key 组成的 Set 视图（去重key）。
                // iterator()迭代器：初始指向元素的上方的空，再.next：指针下移，返回该指针所指向的元素；也就是第一个元素
                int olderKey = cache.keySet().iterator().next();
                cache.remove(olderKey);
            }
            // 新增一个key
            cache.put(key, value);

        }

        /*
        LRU (最近最少使用) 用过的要放到最前
        删掉重新加
         */
        public void makeRecently(int key) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
        }
    }
}
