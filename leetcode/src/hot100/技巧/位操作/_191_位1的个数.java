package hot100.技巧.位操作;

/**
 * https://leetcode.cn/problems/number-of-1-bits/description/
 *
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中设置位的个数（也被称为汉明重量）。
 */
public class _191_位1的个数 {
    /*
    考察 n&(n-1): 作用是消除n中 转为二进制之后的最后那个1
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n!=0){
            n = n & (n-1);
            res ++;
        }
        return res;
    }
}
