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
        if (matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int max = 0;
        int[][] memory = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j =0;j<matrix[0].length;j++){
                max = Math.max(getOnePointLongest(matrix,i,j,memory),max);
            }
        }
        return max;
    }
    int getOnePointLongest(int[][] matrix, int x, int y, int[][] memory){
        if (memory[x][y]!=0){
            return memory[x][y];
        }
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        List<Node> nodes = new LinkedList<>();
        nodes.add(new Node(x,y));
        while (nodes.size() != 0){
            List<Node> tmpNodes = new LinkedList<>();
            for (Node node : nodes){
                int nowX = node.getX();
                int nowY = node.getY();
                for (int[] direction : directions){
                    int newX = nowX+direction[0];
                    int newY = nowY+direction[1];

                    if (newX>=0 && newX<xLength && newY>=0 && newY<yLength){

                        if (matrix[newX][newY]>matrix[nowX][nowY]){
                            if (memory[newX][newY] != 0){
                                memory[nowX][nowY] = Math.max(memory[newX][newY]+1,memory[nowX][nowY]);
                                Node tmpNode = node;
                                while (tmpNode.getLast()!=null){
                                    Node lastNode = tmpNode.getLast();
                                    int lastX = lastNode.getX();
                                    int lastY = lastNode.getY();
                                    memory[lastX][lastY] = Math.max(memory[lastX][lastY],memory[tmpNode.getX()][tmpNode.getY()]+1);
                                    tmpNode = lastNode;
                                }
                                continue;
                            }
                            Node newNode = new Node(newX,newY);
                            newNode.setLast(node);
                            tmpNodes.add(newNode);
                        }
                    }
                }

            }
            if (tmpNodes.size() != 0){
                nodes = tmpNodes;
            } else {
                for (Node node : nodes){
                    int c = 1;
                    memory[node.getX()][node.getY()] = Math.max(c,memory[node.getX()][node.getY()]);

                    while (node.getLast()!=null){
                        if (c<memory[node.getX()][node.getY()]){
                            c = memory[node.getX()][node.getY()];
                        }
                        c++;
                        node = node.getLast();
                        memory[node.getX()][node.getY()] = Math.max(c,memory[node.getX()][node.getY()]);
                    }
                }
                nodes = tmpNodes;
            }
        }

        return memory[x][y];
    }

    public static void main(String[] args) {
        int[][] ma = new int[][]{{6,64,94,3,37,67,35},{91,48,44,18,82,67,44},{19,63,38,36,84,18,5},{87,41,11,32,26,6,60},{68,9,99,70,29,66,94},{59,36,8,31,22,18,51},{64,66,20,66,9,48,15}};
        Q329 q329 = new Q329();
        int i = q329.longestIncreasingPath(ma);
        System.out.println(i);
    }
    class Node{
        int[] coordinate = new int[2];
        Node last;

        public Node(int x, int y) {
            this.coordinate[0] = x;
            this.coordinate[1] = y;
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
