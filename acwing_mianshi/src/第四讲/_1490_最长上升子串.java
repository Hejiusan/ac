package 第四讲;

import java.util.Map;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1492/
 * <p>
 * 给出一个长度为 n 的由正整数构成的序列，你需要从中删除一个正整数，很显然你有很多种删除方式，
 * 你需要对删除这个正整数以后的序列求其最长上升子串，请问在所有删除方案中，最长的上升子串长度是多少。
 * <p>
 * 输入格式
 * 输入第一行仅包含一个正整数 n，表示给出的序列的长度。接下来一行有 n个正整数，即这个序列，中间用空格隔开。
 */
public class _1490_最长上升子串 {
    /*
    l[i]: 表示以第i个数结尾的连续递增子序列的长度
    r[i]: 表示以第i个数开头的连续上升子序列的长度
    状态转移：
        若删除掉a[i] 后 还满足 a[i-1] < a[i+1] 那么他们可以合并。删除第i个数后的 连续上升子串长度为 l[i−1] + r[i+1]
        若不满足，则说明删除后，前后连续子串是独立的，即max(l[i−1],r[i+1])
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+2];
        // 从 1 开始避免索引越界问题
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] l = new int[n + 2];
        int[] r = new int[n + 2];
        l[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (nums[i-1] < nums[i]){
                l[i] = l[i-1] + 1;
            }else { // 不满足了，又重新开始计算长度
                l[i] = 1;
            }
        }

        r[n] = 1;
        for (int i = n-1; i >= 1; i--) {
            if (nums[i] < nums[i+1]){
                r[i] = r[i+1] + 1;
            }else {
                r[i] = 1;
            }
        }
        int res = 0;
        //枚举删除的数
        for (int i = 1; i <= n; i++) {
            if (nums[i-1] < nums[i+1])  res = Math.max(res, l[i-1] + r[i+1]);
            else res = Math.max(res, Math.max(l[i-1], r[i+1]));
        }
        System.out.println(res);
    }
}
