package 第五讲;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1538/
 *
 * 有N堆纸牌，编号分别为 1,2,…,N。每堆上有若干张，但纸牌总数必为 N 的倍数。
 * 可以在任一堆上取若干张纸牌，然后移动。
 * 移牌规则为：在编号为 1 的堆上取的纸牌，只能移到编号为 2的堆上；
 * 在编号为 N 的堆上取的纸牌，只能移到编号为 N−1 的堆上；
 * 其他堆上取的纸牌，可以移到相邻左边或右边的堆上。
 *
 * 现在要求找出一种移动方法，用最少的移动次数使每堆上纸牌数都一样多。
 *
 * 例如 N=4，4堆纸牌数分别为：(9,8,17,6)
 * 移动 3 次可达到目的：
 *  1. 从第三堆取四张牌放入第四堆，各堆纸牌数量变为:(9,8,13,10)。
 *  2. 从第三堆取三张牌放入第二堆，各堆纸牌数量变为:(9,11,10,10)。
 *  3. 从第二堆取一张牌放入第一堆，各堆纸牌数量变为:(10,10,10,10)
 */
public class _1536_均分纸牌 {
    /*
    假设最开始每一堆的牌数量为 a1 a2 。。。 an   平均数为 a‘
    假设 x1、x2.。。xn为a1移到a2、a2移到a3 。。。 an-1 移到 an
    x1 为所有a1转移到a2的牌数 - 所有 a2 转移给a1的牌数
    就有  a1 - x1 = a’
    同理  a2 + x1 - x2 = a’
         。。。
         an-1 + xn-2 - xn-1 = a‘
         an + xn-1 = a’
    求出所有的x
    就有  x1 = a1 - a' + x0(x0=0, 方便循环)
         x2 = a2 - a' + x1
         x3 = a3 - a' + x2
         ...
         xn-1 = an-1 - a' + xn-2
    只要x！=0 就说明有移动，次数+1
     */
    public static void main(String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().split(" ")[0]);
        int [] a = new int[n];
        String [] line = sc.nextLine().split(" ");
        for (int i = 0; i < n; i ++)
        {
            a[i] = Integer.parseInt(line[i]);
        }

        int a_sum = 0;
        for (int x: a)
        {
            a_sum += x;
        }
        int average = a_sum / n;

        int res = 0;
        for (int i = 0, x = 0; i < n; i++) {
            x = a[i] - average + x;
            if (x != 0) res++;
        }

        System.out.println(res);

    }

}
