package 第七讲;

import java.util.Arrays;
import java.util.Scanner;

public class _1572_递归实现指数型枚举II {
    static int[] path;
    static boolean[] st;
    static int n;
    static int[] res;
    static StringBuilder output = new StringBuilder();  // 创建一个StringBuilder来收集输出
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        path = new int[n+1];
        st = new boolean[n+1];
        res = new int[n+1];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        dfs(a, 0);
        System.out.print(output.toString());  // 一次性输出所有内容
        sc.close();
    }

    private static void dfs(int[] a, int start) {
        if (start == n){
            for (int i = 0; i < n; i++) {
//                System.out.printf(res[i] + " ");
                output.append(res[i]).append(" ");
            }
//            System.out.println();
            output.append("\n");
            return;

        }

        for (int i = 0; i < n; i++) {
            if (!st[i]){
                res[start] = a[i];
                st[i] = true;
                dfs(a, start + 1);
                st[i] = false;
                // 剪枝
                while (i + 1 < n && a[i + 1] == a[i]) i ++ ;        //跳过重复,见下图

            }
        }
    }
}
