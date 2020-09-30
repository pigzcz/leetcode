package hard;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/4 15:38
 * @Description:
 * 51. N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Q51 {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] keyData = new int[n][n];
        Set<Integer> set = new HashSet<>();
        doSolveNQueens(keyData,0,n,set);
        return res;
    }

    public void doSolveNQueens(int[][] keyData, int cN, int n, Set<Integer> indexSet){
        if (cN == n){
            res.add(toString(keyData));
            return;
        }
        for (int i=0;i<n;i++){
            if (indexSet.contains(i)){
                continue;
            }else {
                if(!lCan(keyData,cN,i) || !rCan(keyData,cN,i)){
                    continue;
                }
                keyData[cN][i] = 1;
                indexSet.add(i);
                doSolveNQueens(keyData,cN+1,n,indexSet);
                indexSet.remove(i);
                keyData[cN][i] = 0;
            }
        }
    }

    private boolean lCan(int[][] keyData,int x,int y){
        while (x>=0 && x< keyData.length && y>=0 && y<keyData.length){
            if (keyData[x][y]==1){
                return false;
            }
            x--;y--;
        }
        return true;
    }
    private boolean rCan(int[][] keyData,int x, int y){
        while (x>=0 && x< keyData.length && y>=0 && y<keyData.length){
            if (keyData[x][y]==1){
                return false;
            }
            x--;y++;
        }
        return true;
    }


    private List<String> toString(int[][] keySet){
        List<String> res = new ArrayList<>();
        for (int i =0;i<keySet.length;i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<keySet.length;j++){
                if (keySet[i][j] == 1){
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Q51 q51 = new Q51();
        List<List<String>> lists = q51.solveNQueens(5);
        System.out.println(lists);
    }
}
