package 第二讲;

import java.util.Scanner;

/**
 * 经典约瑟夫环问题：
 * N个人围成一圈，第一个人从1开始报数，报M的将被杀掉，下一个人接着从1开始报。如此反复，最后剩下一个，求最后的胜利者。
 * 约瑟夫环递推公式：
 *     f(1) = 0;     //表示最后一轮的胜出者当前编号是0
 *     f(x) = (f(x - 1) + m) % x , 1 < x <= n //每一轮都找到胜出者在上一轮中的编号
 *     不过本题里m是在变化的，所以要相应地变为：
 * ==> f(x) = (f(x - 1) + a[(n - x) % m]) % x, 1 < x <= n
 */
public class _1455_招聘 {
    public static void main(String[] args) {
        int n, m;
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
            for (int i = 1, j = (n - 1) % m; i < n;) {
                i++;
                j = (j + m - 1) % m;
                res = (res + a[j]) % i;
            }
            System.out.println(res);
        }
    }
}
