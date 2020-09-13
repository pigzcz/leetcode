package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class Q79 {
    private boolean res = false;
    public boolean exist(char[][] board, String word) {
        if (null == word || board == null || board.length ==0 || board[0].length ==0){
            return false;
        }
        List<int[]> firstIndex = new ArrayList<>();
        char[] chars = word.toCharArray();
        if (chars.length == 0){
            return false;
        }
        char f = word.toCharArray()[0];
        for (int i=0;i<board.length;i++){
            for (int j =0;j<board[0].length;j++){
                if (board[i][j]==f){
                    firstIndex.add(new int[]{i,j});
                }
            }
        }
        if (firstIndex.size()==0){
            return false;
        }
        int[][] direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int[] tmp :firstIndex){
            try {
                doExist(board,chars,tmp[0],tmp[1],0,direction,used);
            } catch (Exception e){

            }
            if (res){
                return res;
            }

        }
        return false;
    }

    /**
     * [["A","B","C","E"],
     * ["S","F","C","S"],
     * ["A","D","E","E"]]
     * @param board
     * @param words
     * @param x
     * @param y
     * @param cNum
     * @param direction
     */
    void doExist(char[][] board,char[] words, int x ,int y,int cNum, int[][] direction,boolean[][] used){
        if (x>=0 && x<board.length && y>=0 && y<board[0].length){
            if (board[x][y] == words[cNum] && !used[x][y]){
                cNum++;
                used[x][y] = true;
                if (cNum == words.length){
                    this.res =true;
                    throw new RuntimeException("find");
                }
                for (int[] d : direction){
                    doExist(board,words,x+d[0],y+d[1],cNum,direction,used);
                }
                used[x][y] = false;

            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        char[][] borad = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] borad = new char[][]{{'a','a'}};
        Q79 q79 = new Q79();
        boolean abcb = q79.exist(borad, "ABCB");
        System.out.println(abcb);
    }

}
