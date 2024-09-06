package 第五讲;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/124/
 *
 * 有 n 个小朋友坐成一圈，每人有 a[i]个糖果。
 * 每人只能给左右两人传递糖果。每人每次传递一个糖果代价为 1。求使所有人获得均等糖果的最小代价。
 */
public class _122_糖果传递 {
    /*
    围一个圈，a1给a2的相对值为x1.。。。an-1 给 an的为xn-1  因为是环，an给a1的为xn
    假设平均糖果数为 a‘ 就有递推式
    a1 - x1 + xn = a'
    a2 - x2 + x1 = a'
    ...
    an-1 - xn-1 + xn-2 = a'
    an - xn + xn-1 = a'
    其实有一个方程是多余的 所以只有n-1个方程 n个变量。不具备唯一解
    不妨把x1当做自由变量，用x1来表示其他变量
    x1 = x1 - 0
    x2 = x1 - (a' - a2)
    x3 = a3 - a' + (a2 - a' + x1) = x1 + a3 + a2 - 2a'
    x3 = x1 - (2a' - a2 - a3)
    ...
    xn-1 = x1 - ((n-2)a' - a2 - a3 - ... - an-1)
    xn = x1 - ((n-1)a' - a2 - a3 - ... - an)
    目标就是求 |x1| + |x2| + ...+ |xn|的最小值， 将常量抽象成一个变量
    原式 = |x1 - c1| + |x2 - c2| + ...+ |xn - cn|的最小值 转化成了货仓选址问题，中位数就是求得最小值
     */
    static int N = 1000010;
    static long[] a = new long[N];
    static long[] c = new long[N];  // 那一坨常量
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            a[i] += a[i-1];
        }
        long avg = a[n] / n;
        // 求一下c
        for (int i = 2; i <= n; i++) {
            c[i] = (i-1) * avg - (a[i] - a[1]);
        }
        Arrays.sort(c,1,n + 1);
        long mid = c[(n+1)/2];
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += Math.abs(c[i] - mid);
        }
        System.out.println(res);
    }
}
