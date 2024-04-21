package 队列和栈.单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-element-i/description/
 * <p>
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
public class _496_下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 先将nums2的下一个更大元素都找出，再根据nums1的值去查表
        int[] greater = nextGreaterElement(nums2);
        // 因为是根据重叠的值去查，可以用到map key对应value
        HashMap<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            // 把nums2中每一个下一个更大元素存进去
            resMap.put(nums2[i], greater[i]);
        }
        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = resMap.get(nums1[i]);
        }
        return res;
    }

    static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
