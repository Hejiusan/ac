package 回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-queens/description/
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class _51_N皇后 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;

    }

    /**
     * @param board：表示棋盘
     * @param row：表示递归到第几行了
     */
    private void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }
        // 当前行的元素
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            char[] arr = board.get(row).toCharArray();
            arr[col] = 'Q';
            board.set(row, String.valueOf(arr));
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            arr[col] = '.';
            board.set(row, String.valueOf(arr));
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？*/
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
