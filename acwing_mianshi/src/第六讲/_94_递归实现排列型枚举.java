package 第六讲;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/96/
 * 把 1∼n 这 n 个整数排成一行后随机打乱顺序，输出所有可能的次序。
 */
public class _94_递归实现排列型枚举 {
    static int n;
    static boolean[] st;
    static int[] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        st = new boolean[n+1];
        path = new int[n+1];
        dfs(1);
    }

    private static void dfs(int u) {
        if (u > n){
            for (int i = 1; i <= n; i++) {
                System.out.printf(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {  // 既是数字 也是索引  st[i]: 记录i这个数字有没有被用过
            if (!st[i]){
                path[u] = i;
                st[i] = true;
                dfs(u+1);
                st[i] = false;
            }
        }
    }
}
