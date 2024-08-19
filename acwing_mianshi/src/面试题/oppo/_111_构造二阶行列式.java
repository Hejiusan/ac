package 面试题.oppo;

import java.util.Scanner;

/**
 * https://kamacoder.com/problempage.php?pid=1184
 * 小欧希望你构造一个二阶行列式，满足行列式中每个数均为不超过 20 的正整数，且行列式的值恰好等于x。你能帮帮她吗?
 *
 * 输入一个 x
 * 输出： 如果无解，请输出-1。否则输出任意合法行列式即可(输出两行,每行输出两个不超过20的正整数)。
 */
public class _111_构造二阶行列式 {
    /*
    我们需要找到四个不超过 20 的正整数 ( a, b, c, d )，满足 ( ad - bc = x )
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (!findDeterminant(x))
            System.out.println(-1);
    }

    private static boolean findDeterminant(int x) {
        for (int a = 1; a <= 20; a++) {
            for (int b = 1; b <= 20; b++) {
                for (int c = 1; c <= 20; c++) {
                    int top = x + b * c;
                    if (top % a == 0) {  // d肯定得是整数
                        int d = top / a;
                        if (d >= 1 && d <= 20) {
                            System.out.println(a + " " + b);
                            System.out.println(c + " " + d);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
