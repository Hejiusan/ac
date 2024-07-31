package 第二讲;

import java.util.Scanner;

/**
 * 经典约瑟夫环问题： f(N,M)=(f(N−1,M)+M)%N  N个人报数， 报到M的人死
 * N个人围成一圈，第一个人从1开始报数，报M的将被杀掉，下一个人接着从1开始报。如此反复，最后剩下一个，求最后的胜利者。
 * 约瑟夫环递推公式：
 *     f(1) = 0;     //表示最后一轮的胜出者当前编号是0
 *     f(x) = (f(x - 1) + m) % x , 1 < x <= n //每一轮都找到胜出者在上一轮中的编号
 *     不过本题里m是在变化的，所以要相应地变为：
 * ==> f(x) = (f(x - 1) + a[(n - x) % m]) % x, 1 < x <= n
 */
public class _1455_招聘 {
    public static void main(String[] args) {
        int n, m;   // n 个人  m个数字循环
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
            }

            int res = 0;
            // 在这里 i 是人数，a[i]是报的数字
            /*
             j = (n - 1) % m 是为了确保正确使用a数组中的数字 从a[0]开始。
             使用 j = (j + m - 1) % m，可以确保 j 的值始终在数组 a 的索引范围 [0, m-1] 内循环。
             后续更新j时应该是 j = (j-1)%m  但为了避免负数，所以加上了一个m 不影响余数
             */
            for (int i = 1, j = (n - 1) % m; i < n;) {
                i++;
                j = (j + m - 1) % m;
                // res 是一直在更新的 所以赋值之前的res就是上一个res。套入公式
                res = (res + a[j]) % i;
            }
            System.out.println(res);
        }
    }
}
