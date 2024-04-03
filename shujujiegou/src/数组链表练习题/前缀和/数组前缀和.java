package 数组链表练习题.前缀和;

public class 数组前缀和 {

    // 定义前缀和数组
    private int[] preSum;
    public 数组前缀和(int[] nums) {
        // 初始化
        preSum = new int[nums.length + 1];
        // 计算累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}
