package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/16 20:01
 * @Description:
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class Q37 {
    public void solveSudoku(char[][] board) {
        Set<Character>[] hasX = new Set[9];
        Set<Character>[] hasY = new Set[9];
        Set<Character>[] hasG = new Set[9];

        List<int[]> point = new ArrayList<>();
        ready(board,hasX,hasY,hasG,point);
        char[] chars = new char[]{'1','2','3','4','5','6','7','8','9'};
        try {
            doSolve(board,hasX,hasY,hasG,point,0,point.size(),chars);
        } catch (Exception e){

        }

    }

    private void doSolve(char[][] board,Set<Character>[] hasX, Set<Character>[] hasY, Set<Character>[] hasG, List<int[]> point,int start,int end, char[] chars){
        if (start == end){
            throw new RuntimeException("find");
        }
           int i= start;
            int[] sp = point.get(i);
            int x = sp[0];int y = sp[1];
            int g = getGIndex(x,y);
            Set<Character> hasx = hasX[x];
            if (null == hasx){
                hasx = new HashSet<>();
                hasX[x] = hasx;
            }
            Set<Character> hasy = hasY[y];
            if (null == hasy){
                hasy = new HashSet<>();
                hasY[y]=hasy;
            }
            Set<Character> hasg = hasG[g];
            if (null == hasg){
                hasg = new HashSet<>();
                hasG[g] = hasg;
            }
            for (char t : chars){
                if (hasx.contains(t)||hasg.contains(t)||hasy.contains(t)){

                } else {
                    board[x][y]=t;
                    hasx.add(t);
                    hasy.add(t);
                    hasg.add(t);
                    doSolve(board,hasX,hasY,hasG,point,start+1,end,chars);
                    board[x][y]='.';
                    hasx.remove(t);
                    hasy.remove(t);
                    hasg.remove(t);
                }
            }

    }

    private void ready(char[][] board, Set<Character>[] hasX, Set<Character>[] hasY, Set<Character>[] hasG, List<int[]> point){
        int x = board.length;
        int y = board[0].length;
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                if (board[i][j] == '.'){
                    point.add(new int[]{i,j});
                } else {
                    Set<Character> hasXS = hasX[i];
                    if (hasXS == null){
                        hasXS = new HashSet<>();
                        hasX[i] = hasXS;
                    }
                    hasXS.add(board[i][j]);

                    Set<Character> hasYS = hasY[j];
                    if (hasYS == null){
                        hasYS = new HashSet<>();
                        hasY[j] = hasYS;
                    }
                    hasYS.add(board[i][j]);
                    int gIndex = getGIndex(i, j);
                    Set<Character> hasGS = hasG[gIndex];
                    if (null == hasGS){
                        hasGS = new HashSet<>();
                        hasG[gIndex] = hasGS;
                    }
                    hasGS.add(board[i][j]);

                }
            }
        }
    }
    private int getGIndex(int x, int y){
        return y/3 * 3 + x/3;
    }

    public static void main(String[] args) {

        Q37 q37 = new Q37();
        String[][] board = new String[][]{{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        int x = board.length;int y = board[0].length;
        char[][] charb = new char[x][y];
        for (int i =0;i<x;i++){
            for (int j=0;j<y;j++){
                charb[i][j] = board[i][j].charAt(0);
            }
        }

        q37.solveSudoku(charb);
        int gIndex = q37.getGIndex(6, 6);
        System.out.println(gIndex);
    }
}
