package 第二讲;

import java.io.*;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/799/
 *
 * 输入一个长度为 n的整数序列。
 *
 * 接下来输入 m个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r]之间的每个数加上 c
 *
 * 请你输出进行完所有操作后的序列。
 */
public class _797_差分 {
    public static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] sp = stdIn.readLine().trim().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        int []a = new int[n];

        sp = stdIn.readLine().trim().split(" ");
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(sp[i]);

        Difference difference = new Difference(a);

        for (int i = 0; i < m; i++) {
            sp = stdIn.readLine().trim().split(" ");

            int l = Integer.parseInt(sp[0]) - 1;
            int r = Integer.parseInt(sp[1]) - 1;
            int c = Integer.parseInt(sp[2]);

            difference.increment(l, r, c);
            a = difference.result();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }


    static class Difference{
        // 定义一个差分数组
        private int[] diff;
        // 构造函数
        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /*
        给闭区间[i, j] 增加 val  val也可能为负 */
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j+1<diff.length) {
                diff[j+1] -= val;
            }
        }

        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = diff[i] + res[i-1];
            }
            return res;
        }
    }

}

