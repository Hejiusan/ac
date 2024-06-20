package hot100.普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        // 按照区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> merged = new ArrayList<>(); //存储合并后的区间
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // 如果当前区间的结束位置大于或等于下一个区间的开始位置，说明有重叠
                // 需要合并区间
                currentInterval[1] = Math.max(currentEnd, nextEnd); // 区间结束位置更新为较大值
            } else {
                // 不重叠，将当前区间加入结果列表
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
