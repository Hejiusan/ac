package 第五讲;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/106/
 * 在一条数轴上有 N 家商店，它们的坐标分别为 A1∼AN
 * 现在需要在数轴上建立一家货仓，每天清晨，从货仓到每家商店都要运送一车商品。
 *
 * 为了提高效率，求把货仓建在何处，可以使得货仓到每家商店的距离之和最小。
 */
public class _104_货仓选址 {
    /*
    假设货仓在x，也就是求(|x-A1|+|x-A1|+··· + |x-An|)的最小值
    绝对值不等式： |x| + |y| >= |x+y| == > |x-a| + |x-b| = |x-a| + |b-x| >= |x-a +b -x| = |a-b|
       |x-A1|+|x-A2|+··· + |x-An|  首尾两两一组
    >= |A1-AN| + |A2-A(N-1)| + ··· +
    求最小值，也就是首尾每一组的距离差求最小值，当x处于中间的时候，就可以凑出两两一组，求出最小值

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);   // 还可以更快，求中位数，快速选择算法
        int mid = arr[n / 2];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(arr[i] - mid);
        }
        System.out.println(res);
    }
}
