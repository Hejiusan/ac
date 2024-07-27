package hot100.图论;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class _208_实现Trie_前缀树 {
    class Trie {

        private static final int N = 4010;  // 最大节点数

        //一维是结点总数，而结点和结点之间的关系（谁是谁儿子）存在第二个维度，
        //比如[0][1]=3, [0]表示根节点，[1]表示它有一个儿子‘b’,这个儿子的下标是3；
        //接着如果有一个[3][2]=8 ; 说明根节点的儿子‘b’也有一个儿子‘c’，这个孙子的下标就是8；
        //这样传递下去，就是一个字符串。
        //随便给一个结点][x][y], 并不能看出它在第几层，只能知道，它的儿子是谁
        private int[][] son;  // 存储子节点的下标
        private int idx;      // 当前使用的下标
        private boolean[] isEnd;  // 标记是否为单词的结尾

        public Trie() {
            son = new int[N][26]; // 26个字母
            isEnd = new boolean[N];
            idx = 0;  // 根节点的下标为0，也是初始下标
        }

        public void insert(String str) {
            int p = 0;  // 从根节点开始
            for (int i = 0; i < str.length(); i++) {
                int u = str.charAt(i) - 'a';  // 将字符转换为下标
                if (son[p][u] == 0) {
                    son[p][u] = ++idx;  // 如果不存在该子节点，则创建
                }
                p = son[p][u];
            }
            isEnd[p] = true;  // 标记单词结束的节点
        }

        public boolean search(String word) {
            int p = 0;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (son[p][u] == 0) return false;  // 如果路径中断，说明单词不存在
                p = son[p][u];
            }
            // 还需要判定 路径的最后一个节点就是字符串的终点
            return isEnd[p];  // 确认最后到达的节点是一个单词的结尾

        }

        public boolean startsWith(String prefix) {
            int p = 0;
            for (int i = 0; i < prefix.length(); i++) {
                int u = prefix.charAt(i) - 'a';
                if (son[p][u] == 0) return false;  // 如果路径中断，说明单词不存在
                p = son[p][u];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
