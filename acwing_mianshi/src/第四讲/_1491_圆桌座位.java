package 第四讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1493/
 * N 个人围坐一圈，有 M 对朋友关系。
 *
 * 第 i 对朋友关系是指，编号是 ai 的人和编号是 bi 的人是朋友。
 * 现在要给他们安排座位，要求所有相邻的人不能是朋友。问共有多少种方案？
 *
 * 如果两个方案只有旋转角度不同，则我们将其视为一种方案。
 */
public class _1491_圆桌座位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]); // N 个人
        int m = Integer.parseInt(s[1]); // m 对关系
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            s = sc.nextLine().split(" ");
            a[i] = Integer.parseInt(s[0]);
            b[i] = Integer.parseInt(s[1]);
        }
    }
}
