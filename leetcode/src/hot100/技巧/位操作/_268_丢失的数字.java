package hot100.技巧.位操作;

/**
 * https://leetcode.cn/problems/missing-number/description/
 * <p>
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class _268_丢失的数字 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // 0~n 等差数列求和 （首项+尾项）* 项数 /2
        int Sn = (0 + n) * (n + 1) / 2;
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return Sn - res;
    }

    public int missingNumber2(int[] nums) {
        /*
        位操作：因为数字从0~n  索引也是
         */
        int n = nums.length;
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
}
