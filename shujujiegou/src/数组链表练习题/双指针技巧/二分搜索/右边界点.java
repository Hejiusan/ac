package 数组链表练习题.双指针技巧.二分搜索;

public class 右边界点 {
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 最后改成返回 left - 1
        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    /**
     * acwing 最小的最大值点
     * @param l
     * @param r
     * @return
     */
    // 区间[l,r]被划分成[l, mid]和[mid+1, r]时使用
//    int bsearch_2(int l, int r)
//    {
//        while(l<r)
//        {
//            int mid = l + r >> 1;
//            if(check(mid))	r = mid;
//            else l = mid + 1;
//        }
//        retuen l;
//    }
}
