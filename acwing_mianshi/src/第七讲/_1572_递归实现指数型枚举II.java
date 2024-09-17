package 第七讲;

import java.util.Arrays;
import java.util.Scanner;

public class _1572_递归实现指数型枚举II {
    static boolean[] st;
    static int n;
    static int[] res;
    static StringBuilder output = new StringBuilder();  // 创建一个StringBuilder来收集输出

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        st = new boolean[n + 1];
        res = new int[n + 1];
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a, 0, n);
        dfs(a, 0);
        System.out.print(output.toString());  // 一次性输出所有内容
        sc.close();
    }

    private static void dfs(int[] a, int start) {
        if (start == n) {
            for (int i = 0; i < n; i++) {
//                System.out.printf(res[i] + " ");
                if (st[i]) output.append(res[i]).append(" ");
            }
//            System.out.println();
            output.append("\n");
            return;

        }


        if (!st[start]) {
            res[start] = a[start];
            st[start] = true;
            dfs(a, start + 1);
            st[start] = false;
            // 剪枝
            if (start > 0 && a[start] == a[start - 1] && st[start - 1]) return;  //剪枝
            // 因为我可以不选然后继续递归，所以可以出现空和只选一个的情况。并且此时的start已经走到n（遍历完数组）
            dfs(a, start + 1);
        }

    }
}
