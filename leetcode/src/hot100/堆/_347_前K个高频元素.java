package hot100.堆;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int num : nums) {
            valToFreq.put(num, valToFreq.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>>
                pq = new PriorityQueue<>((entry1, entry2) -> {
            // 队列按照键值对中的值（元素出现频率）从小到大排序
            return entry1.getValue()-entry2.getValue();
        });

        for (Map.Entry<Integer, Integer> entry : valToFreq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                // 弹出最小元素，维护队列内是 k 个频率最大的元素
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            // res 数组中存储前 k 个最大元素
            res[i] = pq.poll().getKey();
        }

        return res;

    }
}
