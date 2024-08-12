package 第四讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1492/
 *
 * 给出一个长度为 n 的由正整数构成的序列，你需要从中删除一个正整数，很显然你有很多种删除方式，
 * 你需要对删除这个正整数以后的序列求其最长上升子串，请问在所有删除方案中，最长的上升子串长度是多少。
 *
 输入格式
 输入第一行仅包含一个正整数 n，表示给出的序列的长度。接下来一行有 n个正整数，即这个序列，中间用空格隔开。
 */
public class _1490_最长上升子串 {
    /*
    dp[i]: 表示以第i个数结尾的最长递增子序列的长度
    状态转移：
        nums[i] > nums[j] ==> dp[i] = dp[j] + 1

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

    }
}
