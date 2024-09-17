package 第六讲;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1539/
 *
 * 给定一个长度为 n 的可包含重复数字的序列，请你求出其所有不重复的全排列。
 *
 *
 */
public class _1537_递归实现排列类型枚举II {
    static int n;
    static boolean[] st;
    static int[] path;
    static StringBuilder output = new StringBuilder();  // 创建一个StringBuilder来收集输出

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nums = new int[n];
        st = new boolean[n];
        path = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        dfs(nums, 0);
        System.out.print(output.toString());  // 一次性输出所有内容
        sc.close();
    }

    private static void dfs(int[] nums, int start) {
        if (start == n){
            for (int i = 0; i < n; i++) {
                output.append(path[i]).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!st[i]){
                path[start] = nums[i];  // start记录的是结果的索引
                st[i] = true;
                dfs(nums, start + 1);
                st[i] = false;
                // 剪枝
                while (i+1 < n && nums[i] == nums[i+1]) i++;
            }
        }

    }
}
