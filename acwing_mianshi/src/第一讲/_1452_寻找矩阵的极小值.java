package 第一讲;

/**
 * https://www.acwing.com/problem/content/1454/
 * 给定一个 n×n的矩阵，矩阵中包含 n×n个 互不相同 的整数。
 * 定义极小值：如果一个数的值比与它相邻的所有数字的值都小，则这个数值就被称为极小值。
 * 一个数的相邻数字是指其上下左右四个方向相邻的四个数字，另外注意，处于边界或角落的数的相邻数字可能少于四个。
 * 要求在 O(nlogn)的时间复杂度之内找出任意一个极小值的位置，并输出它在第几行第几列。
 * 本题中矩阵是隐藏的，你可以通过我们预设的 int 函数 query来获得矩阵中某个位置的数值是多少。
 * 例如，query(a,b)即可获得矩阵中第 a行第 b列的位置的数值。
 * 注意：
 * 矩阵的行和列均从 0开始编号。
 * query()函数的调用次数不能超过 (n+2)×⌈log2n⌉+n。
 * 答案不唯一，输出任意一个极小值的位置即可。
 */
public class _1452_寻找矩阵的极小值 {
    /*
    对列进行二分。从中间列开始，找出这列的最小值val，看他的左右 l 和 r；如果有比val更小的，那么范围就能够缩小到小的那半边。
    且因为val已经是当前列的最小值，所以这一列会挡住从val遍历出的值，只会限定在小的那一侧。
    继续二分就可以将数据规模变小
     */
    public int[] getMinimumValue(int n) {
        int INF = Integer.MAX_VALUE;   // 定义一个极大值
        int val = INF;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            int k = 0;
            for (int i = 0; i < n; i++) {
                int t = query(i, mid);
                if (t < val) {
                    val = t;
                    k = i;
                }
            }
            int left = mid > 0 ? query(k, mid - 1) : INF;
            int right = mid + 1 < n ? query(k, mid + 1) : INF;
            if (val < left && val < right) return new int[]{k, mid};
            if (left < val) r = mid - 1;
            else l = mid + 1;
        }
        // 二分完只剩最后一列，找这一列的最小值
        int k = 0;
        val = INF;
        for (int i = 0; i < n; i++) {
            int t = query(i, r);
            if (t < val) {
                val = t;
                k = i;
            }
        }
        return new int[]{k, r};
    }

    private int query(int i, int mid) {
        return 0;
    }
}
