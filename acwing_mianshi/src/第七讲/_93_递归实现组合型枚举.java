package 第七讲;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/95/
 * 从 1∼n 这 n 个整数中随机选出 m个，输出所有可能的选择方案。
 *
 * 输入格式
 * 两个整数 n,m,在同一行用空格隔开。
 *
 * 输出格式
 * 按照从小到大的顺序输出所有方案，每行 1 个。
 */
public class _93_递归实现组合型枚举 {
    static int n, m;
    static LinkedList<Integer> path = new LinkedList<>();
    static StringBuilder output = new StringBuilder();  // 创建一个StringBuilder来收集输出

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dfs(1);
        System.out.print(output.toString());  // 一次性输出所有内容
        sc.close();
    }

    private static void dfs(int start) {

        // 如果满足条件要求的m个数了 或者说本次dfs 剩下的数不满足凑出m个数了 直接结束
        if(path.size() > m || path.size() + (n - start + 1) < m)
            return;
        //到达枚举边界，输出结果并结束
        if(start == n + 1)
        {
            for (Integer i : path) {
                output.append(i).append(" ");
            }
            output.append("\n");
            return;
        }


        path.add(start);
        dfs(start + 1);
        path.removeLast();
        dfs(start + 1);

    }
}
