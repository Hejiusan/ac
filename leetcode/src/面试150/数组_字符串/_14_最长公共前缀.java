package 面试150.数组_字符串;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 */
public class _14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String prefix = strs[0];
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()){
                break;
            }
        }
        return prefix;






//        if (strs.length == 0){
//            return "";
//        }
//        else{
//            String common_prefix = strs[0];
//            for (String str: strs){
//                while (str.indexOf(common_prefix) != 0) {
//                    common_prefix = common_prefix.substring(0, common_prefix.length() - 1);
//                    if (common_prefix.isEmpty())
//                        return "";
//                }
//            }
//            return common_prefix;
//        }
    }

    /**
     * 计算前缀
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
