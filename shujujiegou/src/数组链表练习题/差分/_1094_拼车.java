package 数组链表练习题.差分;

/**
 * https://leetcode.cn/problems/car-pooling/description/
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，
 * 接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 */
public class _1094_拼车 {

    public boolean carPooling(int[][] trips, int capacity) {
        int nums[] = new int[1001];
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1; //trip[2]位置已经下车了 所以应该-1
            difference.increment(i,j,val);
        }

        int[] result = difference.result();
        for (int i = 0; i < result.length; i++) {
            if (capacity < result[i]){
                return false;
            }
        }
        return true;
    }

    class Difference {
        /*
        nums[0 ]= 0;
        diff[1] = nums[1] - nums[0];
        diff[2] = nums[2] - nums[1];
        diff[3] =nums [3] - nums[2];
        ........
        diff[n] = nums[n] - nums[n-1];
        累加可以得到 nums[n]=diff[1]+diff[2]+···+diff[n]
         */

        //1、定义查分数组
        private int[] diff;

        public Difference(int[] nums){
            assert nums.length > 0;
            diff = new int[nums.length];
            // 构建差分数组
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i]- nums[i-1];
            }
        }

        // 闭区间增减
        public void increment(int i, int j, int val){
            diff[i] += val;
            if (j+1 < diff.length){ //注意边界
                diff[j+1] -= val;
            }
        }

        // 返回前缀和
        public int[] result(){
            int[] res = new int[diff.length];
            // 初始化
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                // 这里的res就是指的nums数组  因为有diff[n] = nums[n] - nums[n-1];，所以可以计算出res[i]
                res[i] = diff[i] + res[i-1];
            }
            return res;
        }
    }
}
