package 图算法.图的遍历;

import java.io.*;
import java.util.*;

/**
 * https://kamacoder.com/problempage.php?pid=1183
 *
 * 字典 strList 中从字符串 beginStr 和 endStr 的转换序列是一个按下述规格形成的序列：
 * 1. 序列中第一个字符串是 beginStr。
 * 2. 序列中最后一个字符串是 endStr。
 * 3. 每次转换只能改变一个字符。
 * 4. 转换过程中的中间字符串必须是字典 strList 中的字符串，且strList里的每个字符串只用使用一次。
 *
 * 给你两个字符串 beginStr 和 endStr 和一个字典 strList，找到从 beginStr 到 endStr 的最短转换序列中的字符串数目。如果不存在这样的转换序列，返回 0。
 * 输入：
 * 6
 * abc def
 * efc
 * dbc
 * ebc
 * dec
 * dfc
 * yhn
 */
public class _110_字符串接龙 {
    // java快速输入输出模版
    public static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter stdOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    /*
    点要连成线，再通过BFS去找最短路径
    这里连接的标准就是只能差一个字符
     */
    public static void main(String[] args) throws IOException {
        Set<String> strSet = new HashSet<>();
        // 记录strSet里的字符串是否被访问过，同时记录路径长度
        Map<String, Integer> visitMap = new HashMap<>(); // <记录的字符串，路径长度>

        int n = Integer.parseInt(stdIn.readLine().trim());
        String[] sp = stdIn.readLine().trim().split(" ");
        String beginStr = sp[0];
        String endStr = sp[1];
        for (int i = 0; i < n; i++) {
            strSet.add(stdIn.readLine().trim());
        }

        // 初始化队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginStr);

        // 初始化visitMap
        visitMap.put(beginStr, 1);

        while(!queue.isEmpty()) {
            String word = queue.poll();
            int path = visitMap.get(word); // 这个字符串在路径中的长度

            // 开始在这个str中，挨个字符去替换
            for (int i = 0; i < word.length(); i++) {
                char[] charArray = word.toCharArray(); // 用一个新字符串替换str，因为每次要置换一个字符
                // 遍历26的字母
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newWord = new String(charArray);
                    if (newWord.equals(endStr)) {
                        stdOut.println(path+1);
                        stdOut.flush();
                        return;
                    }
                    // 字符串集合里出现了newWord，并且newWord没有被访问过
                    if (strSet.contains(newWord) && !visitMap.containsKey(newWord)) {
                        visitMap.put(newWord, path + 1);
                        queue.offer(newWord);
                    }
                }

            }
        }
        stdOut.println(0);
        stdOut.flush();
    }
}
