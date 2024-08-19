package 面试题.oppo;

import java.util.Scanner;

/**
 * 小欧正在一个回合制格斗游戏中挑战一个boss。已知游戏的0/3机制如下:
 * 每回合小欧先手攻击boss，然后boss攻击小欧，此时1回合结束。
 * 小欧有时可以闪避boss的攻击，当闪避成功时这回合将不受boss的伤害。 小欧攻击boss时可以攒“连击点”，
 * 她攻击造成的伤害为a+kb，其中a为基础攻击力，b为基础连击伤害，k为连击次数。小欧每次攻击后会让连击次数加1，但当小欧受到伤害后会重置连击次数为0。
 * 小欧想知道，她最终共对boss造成了多少伤害?
 * shuru:
     * 第一行输入三个正整数n,a,b，代表回合的数量，小欧基础攻击力，小欧的基础连击伤害。
     * 第二行输入一个长度为n的字符串，字符串仅由o和x组成，其中o代表本回合闪避成功，x代表本回合闪避失败。
 */
public class _112_挑战boss {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]); // 回合数
        int a = Integer.parseInt(s[1]); // 基础攻击力
        int b = Integer.parseInt(s[2]); // 连击伤害
        


    }
}
