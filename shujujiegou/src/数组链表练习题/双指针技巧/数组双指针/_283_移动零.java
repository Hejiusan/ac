package 数组链表练习题.双指针技巧.数组双指针;

/**
 * https://leetcode.cn/problems/move-zeroes/
 *
 * 可以转化成把数组中的元素0去除，再把剩下的位置补0
 */
public class _283_移动零 {
    static class Solution {
        public static void moveZeroes(int[] nums) {
            int fast = 0, slow = 0;
            for (;fast< nums.length; fast++){
                if (nums[fast] !=0){
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            //nums依次赋值了前面去掉0的元素；剩下的赋值为0
            for (; slow < nums.length; slow++) {
                nums[slow]=0;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,0,3,12};
        Solution.moveZeroes(nums);
    }
}
