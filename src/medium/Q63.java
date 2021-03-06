package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/28 16:05
 * @Description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * {{0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0},
 * {0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1,0,0},
 * {1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,1},
 * {0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
 * {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
 * {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0},
 * {0,0,0,0,0,1,0,0,0,0,1,1,0,1,0,0,0,0},
 * {1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0},
 * {0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0},
 * {0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
 * {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 * {1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
 * {0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0},
 * {0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0},
 * {0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
 * {0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
 * {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
 * {1,0,1,1,0,0,0,0,0,0,1,0,1,0,0,0,1,0},
 * {0,0,0,1,0,0,0,0,1,1,1,0,0,1,0,1,1,0},
 * {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
 * {0,1,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0},
 * {0,0,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,0},
 * {0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1},
 * {0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0},
 * {1,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0},
 * {0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
 * {0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,0},
 * {1,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,1},
 * {1,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0}}
 */
public class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int pathLength = m+n-1;

        int[][] directions = new int[][]{{1,0},{0,1}};

        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        if (obstacleGrid[0][0] == 0 && pathLength == 1){
            return 1;
        }
        int i=1;
        /**
         * 记录到达该店的路径和
         */
        int memorry[][] = new int[m][n];

        /**
         * 记录该点是第几次到达
         */
        int[][] arrive = new int[m][n];
        arrive[0][0] = 1;
        memorry[0][0] = 1;
        while (i<pathLength){
            for (int x = 0;x<m;x++){
                for (int y =0;y<n;y++){
                    if (arrive[x][y]==i){
                        for (int[] direction : directions){
                            int newX = x + direction[0];
                            int newY = y + direction[1];
                            if (newX>=0&&newX<m&&newY>=0&&newY<n){
                                if (obstacleGrid[newX][newY] !=1){
                                    /**
                                     * 到达该点的路径和等于到达上点的路径和加上到达该点的路径和，因为该点会重复到达
                                     */
                                    memorry[newX][newY] = memorry[newX][newY] + memorry[x][y];
                                    arrive[newX][newY] = i+1;
                                }
                            }
                        }
                    }
                }
            }
            i++;

        }
        return memorry[m-1][n-1];
    }


    public static void main(String[] args) {
//        int[][] m = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] m = new int[][]{{0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1,0,0},
  {1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,1},
  {0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0},
  {0,0,0,0,0,1,0,0,0,0,1,1,0,1,0,0,0,0},
  {1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0},
  {0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0},
  {0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0},
  {0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0},
  {0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0},
  {0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
  {0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
  {1,0,1,1,0,0,0,0,0,0,1,0,1,0,0,0,1,0},
  {0,0,0,1,0,0,0,0,1,1,1,0,0,1,0,1,1,0},
  {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
  {0,1,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0},
  {0,0,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,0},
  {0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1},
  {0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0},
  {1,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0},
  {0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
  {0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,0},
  {1,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,1},
 {1,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0}};
        Q63 q63 = new Q63();
        int i = q63.uniquePathsWithObstacles(m);
        System.out.println(i);
    }
}
