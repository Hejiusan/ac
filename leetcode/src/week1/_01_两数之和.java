package week1;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/two-sum/
 */
public class _01_两数之和 {
    //暴力
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i+1; j < nums.length; j++) {
//                    if (nums[i]+nums[j] == target)
//                        return new int[]{i,j};
//                }
//            }
//            return null;
//        }
//    }
//
    //O（n)复杂度
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int need = target - nums[i];
                if (map.containsKey(need)){ //找到了第二个元素
                    return new int[]{i,map.get(need)};
                }
                //存入（val -> index）的映射
                map.put(nums[i], i);
            }
            return null;
        }
    }
}
