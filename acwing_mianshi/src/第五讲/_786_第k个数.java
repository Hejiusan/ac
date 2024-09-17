package 第五讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/788/
 * 给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。
 */
public class _786_第k个数 {
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        nums = new int[n];
        s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.println(quickSort(0, n - 1, k - 1));
    }

    public static int quickSort(int l, int r, int k) {
        if (l >= r) return nums[k];
        /*
        选取 nums[l] 作为基准元素 x。
        •	使用两个指针 i 和 j，分别从区间的两端向中间扫描，将所有小于 x 的元素移动到左边，所有大于 x 的元素移动到右边。
        •	这个过程中，i 从左向右移动，寻找大于或等于 x 的元素；j 从右向左移动，寻找小于或等于 x 的元素。
        •	当找到这样的元素对时，交换 nums[i] 和 nums[j]。
        •	循环结束的条件是 i 和 j 相遇。
         */
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        /*
        完成一轮划分后，基准元素 x 的正确位置是 j。
        •	检查 k 的位置与 j 的关系：
        •	如果 k <= j，说明第 k 小的元素在左边部分，对左半部分递归调用 quickSort。
        •	如果 k > j，说明第 k 小的元素在右边部分，对右半部分递归调用 quickSort。
         */
        if (k <= j) return quickSort(l, j, k);
        else return quickSort(j + 1, r, k);
    }

}
