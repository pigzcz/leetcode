package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * [
 *   [7,8,9],
 *   [9,7,6],
 *   [7,2,3]
 * ]
 * [[1, 6,12,1, 3],
 * [8,  4,6,10, 5],
 * [12,11,7,12, 2],
 * [2, 3, 4,1, 13],
 * [14,6, 0,14,13]]
 *
 * [[6,64,94, 3, 37,67,35],
 * [91,48,44, 18,82,67,44],
 * [19,63,38, 36,84,18,5],
 * [87,41,11, 32,26,6, 60],
 * [68,9, 99, 70,29,66,94],
 * [59,36,8, 31, 22,18,51],
 * [64,66,20,66, 9, 48,15]]
 */
public class Q329 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int [][] arrive = new int[xLength][yLength];
        int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

        List<int[]> canArrive = new ArrayList<>(xLength*yLength);
        for (int x=0;x<xLength;x++){
            for (int y=0;y<yLength;y++){
                int c =0;
                for (int[] direction : directions){
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX>=0&&newX<xLength && newY>=0&&newY<yLength){
                        if (matrix[newX][newY]<matrix[x][y]){
                            c++;
                        }
                    }
                }
                if (c==0){
                    arrive[x][y] = 1;
                    canArrive.add(new int[]{x,y});
                }
            }
        }

        boolean find =true;
        int c = 1;
        while (find){
            int findCount = 0;
            List<int[]> tmpFind = new ArrayList<>(xLength*yLength);
            for (int[] coordinate : canArrive){
                int x = coordinate[0];
                int y = coordinate[1];
                for (int[] direction : directions){
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX>=0&&newX<xLength && newY>=0&&newY<yLength){
                        if (matrix[newX][newY]>matrix[x][y]){
                            if (arrive[newX][newY] != c+1){
                                arrive[newX][newY] = c+1;
                                findCount++;
                                tmpFind.add(new int[]{newX,newY});
                            }
                        }
                    }
                }
            }
            if (findCount == 0){
                find = false;
            } else {
                canArrive = tmpFind;
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String x = "[[0,1,2,3,4,5,6,7,8,9],[19,18,17,16,15,14,13,12,11,10],[20,21,22,23,24,25,26,27,28,29],[39,38,37,36,35,34,33,32,31,30],[40,41,42,43,44,45,46,47,48,49],[59,58,57,56,55,54,53,52,51,50],[60,61,62,63,64,65,66,67,68,69],[79,78,77,76,75,74,73,72,71,70],[80,81,82,83,84,85,86,87,88,89],[99,98,97,96,95,94,93,92,91,90],[100,101,102,103,104,105,106,107,108,109],[119,118,117,116,115,114,113,112,111,110],[120,121,122,123,124,125,126,127,128,129],[139,138,137,136,135,134,133,132,131,130],[0,0,0,0,0,0,0,0,0,0]]";
        System.out.println(x.replace("[","{").replace("]","}"));
        int[][] ma = new int[][]{{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
        Q329 q329 = new Q329();
        int i = q329.longestIncreasingPath(ma);
        System.out.println(i);
    }
    class Node{
        int[] coordinate = new int[2];
        Node last;
        int value;

        public Node(int x, int y, int[][] matrix) {
            this.coordinate[0] = x;
            this.coordinate[1] = y;
            value = matrix[x][y];
        }

        public int getX(){
            return coordinate[0];
        }
        public int getY(){
            return coordinate[1];
        }

        public Node getLast() {
            return last;
        }

        public void setLast(Node last) {
            this.last = last;
        }
    }
}
