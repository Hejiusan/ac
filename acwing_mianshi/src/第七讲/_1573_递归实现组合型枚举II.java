package 第七讲;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1575/
 * <p>
 * 给定一个长度为 n 的可包含重复数字的序列，从中随机选取 m 个数字，输出所有可能的选择方案。
 */
public class _1573_递归实现组合型枚举II {
    static int n, m;
    static int[] a;
    static LinkedList<Integer> path = new LinkedList<>();
    static StringBuilder output = new StringBuilder();  // 创建一个StringBuilder来收集输出

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = sc.nextLine().split(" ");
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(a);
        dfs(0, 0);
        System.out.print(output.toString());  // 一次性输出所有内容
        sc.close();
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < path.size(); i++) {
                output.append(path.get(i));
                if (i < path.size() - 1) output.append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            // 跳过相同的元素，避免输出重复组合
            if (i > start && a[i] == a[i - 1]) continue;
            path.add(a[i]);
            dfs(i + 1, depth + 1); // 继续递归，注意深度加1
            path.removeLast(); // 回溯
        }
    }
}
