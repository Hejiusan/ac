package hot100.回溯;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true; // 找到了单词的全部字符
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false; // 越界
        }
        if (visited[row][col]) {
            return false; // 当前单元格已访问过
        }
        if (board[row][col] != word.charAt(index)) {
            return false; // 当前单元格的字符与单词的当前字符不匹配
        }

        visited[row][col] = true; // 标记当前单元格为已访问
        // 搜索四个方向
        boolean result = dfs(board, word, index + 1, row + 1, col, visited) ||
                dfs(board, word, index + 1, row - 1, col, visited) ||
                dfs(board, word, index + 1, row, col + 1, visited) ||
                dfs(board, word, index + 1, row, col - 1, visited);
        visited[row][col] = false; // 回溯，将当前单元格标记为未访问
        return result;
    }
}
