package 面试150.数组_字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150
 */
public class _12_整数转罗马数字 {
    public String intToRoman(int num) {
        String[] ch = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder res = new StringBuilder();
        // 从最大的开始凑
        for (int i = 0; i < ch.length; i++) {
            while (num >= val[i]){
                num -= val[i];
                res.append(ch[i]);
            }
        }
        return res.toString();
    }

}
