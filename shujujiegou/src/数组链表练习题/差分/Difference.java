package 数组链表练习题.差分;

//
class Difference {
    //差分数组
    private int[] diff;


    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /*
    给闭区间[i, j] 增加 val  val也可能为负 */
    public void increment(int i, int j, int val) {
        diff[i] += val;     // 将序列中[i,..]之间每个数都 + val
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;     // 再将 [j+1,..]之间每个数都 -val 那么就只有[i,j]这个区间的数进行了 +val
        }
    }

    /*
     */
    public int[] result() {
        // res是前缀和。diff是前缀和的差分
        // 可以通过差分数组逆向推出前缀和
        int[] res = new int[diff.length];
        //
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            // res[i] - res[i - 1] = diff[i] 换算来的
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}

