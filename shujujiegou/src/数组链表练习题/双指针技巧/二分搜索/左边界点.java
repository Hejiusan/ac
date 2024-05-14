package 数组链表练习题.双指针技巧.二分搜索;

/**
 * 最大的最小值点
 */
public class 左边界点 {
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 如果越界，target 肯定不存在，返回 -1
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }



    /**
     * acwing模版
     * @param l
     * @param r
     * @return
     */
    // 区间[l,r]被划分成[l, mid-1]和[mid, r]时使用
//    int binary_search_1(int l, int r)
//    {
//        while (l < r)//l,r分别是左右边界
//        {
//            int mid = l + r + 1 >> 1;//切记要加上1，防止死循环  >>1 表示右移一位 也就是➗2
//            //这里是根据下面这个l=mid还是l=mid+1决定的
//            //如果是l=mid 切记前面mid就一定要加上1（下面给出解释）
//            if (check(mid)) l = mid;
//            else r = mid - 1;
//        }//check函数其实是最重要的！！我会在题目中详细说明
//        return l;
//    }

}
