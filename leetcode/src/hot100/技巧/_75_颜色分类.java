package hot100.技巧;

/**
 * https://leetcode.cn/problems/sort-colors/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        quick_sort(nums, l, r);

    }

    private void quick_sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int x = nums[(l + r) / 2];
        int i = l - 1;     // 左指针
        int j = r + 1;    // 右指针
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);    // 当i指向的数> 中间值；j指向的数< 中间值， 且i<j； 则交换
        }

        quick_sort(nums, l, j);
        quick_sort(nums, j + 1, r);
    }

    private void swap(int[] nums,int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        _75_颜色分类 main = new _75_颜色分类();
        main.sortColors(nums);
    }

}
