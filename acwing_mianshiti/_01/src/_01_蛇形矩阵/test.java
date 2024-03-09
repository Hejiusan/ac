package _01_蛇形矩阵;

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
public class test {
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res[][] = new int[101][101];
        for (int x = 0, y = 0, k =1, d=0; k <= n*m; k++) {
            res[x][y] = k;
            int a = x+dx[d];
            int b = y+dy[d];
            // 下一步需要转向 或者已经走过了
            if (a<0 || a>=n ||b<0 ||b>=m || res[a][b] > 0){
                d = (d+1)%4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
