package medium;

import java.awt.font.FontRenderContext;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */
public class Q130 {
    public void solve(char[][] board) {
        if (null == board){
            return;
        }
        if (board.length==0){
            return;
        }
        if (board[0].length==0){
            return;
        }
        int[][] dp = new int[board.length][board[0].length];
        int tmp = 1;
        int[][] direct = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        boolean find = false;
        for (int i =0;i<board.length;i++){
            if (board[i][0] == 'O'){
                dp[i][0] = tmp;

                find = true;
            }
            if (board[i][board[0].length-1]=='O'){
                dp[i][board[0].length-1] = tmp;

                find = true;
            }
        }
        for (int i=0;i<board[0].length;i++){
            if (board[0][i] == 'O'){
                dp[0][i] = tmp;

                find = true;
            }
            if (board[board.length-1][i] == 'O'){
                dp[board.length-1][i] = tmp;

                find = true;
            }
        }

        while (find){
            find = false;
            for (int i=0;i<board.length;i++){
                for (int j =0;j<board[0].length;j++){
                    if (dp[i][j]==tmp){
                        for (int[] tmpd : direct){
                            int newX = i+tmpd[0];
                            int newY = j+tmpd[1];
                            if (newX>0 && newX<board.length-1 && newY>0 && newY<board[0].length-1){
                                if(board[newX][newY] == 'O'&& dp[newX][newY]==0){
                                    dp[newX][newY] = tmp+1;

                                    find = true;
                                }
                            }
                        }
                    }
                }
            }
            tmp++;
        }
        for (int i=0;i<board.length;i++){
            for (int j =0;j<board[0].length;j++){
                if (dp[i][j]==0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }


    }
}
