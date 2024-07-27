package 第一讲._01_蛇形矩阵;

import java.util.Scanner;

/**
 * 定义偏移量: 四个方向
 * 右：（0，1）
 * 下：（1，0）
 * 左：（0，-1）
 * 上：（-1，0）
 * 走到头了，需要转向：两种情况
 * ① 出界、 ② 走到重复格子
 */
public class Main {
    public static void main(String[] args) {
        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 记录这个点是否被走过
        int res[][] = new int[101][101];
        // 从左上角（0，0）开始循环，填的数字k从1开始，方向d从0开始
        for (int x = 0, y = 0, k = 1, d = 0; k <= n * m; k++) {
            res[x][y] = k;
            //记录变化的坐标
            int a = x + dx[d], b = y + dy[d];
            //判断是否走到头了
            if (a < 0 || a >= n || b < 0 || b >= m || res[a][b] > 0) {
                // 转向：也就是d从0-》1-》2-》3循环  可以通过取模来实现
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}
