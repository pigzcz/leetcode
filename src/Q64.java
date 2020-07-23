/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/23 11:26
 * @Description:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 */
public class Q64 {
    private int[][]S;

    //设到达的grid[m][n]的最短距离为S[m][n]，由于只能从grid[m-1][n],grid[m][n-1]点到达grid[m][n]
    //所以S[m][n] = min(S[m-1][n]+grid[m][n],S[m][n-1]+grid[m][n])
    //注意临界值的处理
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        S = new int[m][n];
        return min(m-1,n-1,grid);
    }
    int min(int m,int n,int[][] grid){
        if (S[m][n] != 0){
            return S[m][n];
        }
        int result=0;
        if (m==0 && n==0){
             result=grid[0][0];
            S[m][n] = result;
            return result;
        }
        if (m-1<0){
            result = min(m,n-1,grid) + grid[m][n];
            S[m][n] = result;
            return result;
        }
        if (n-1<0){
            result = min(m-1,n,grid)+grid[m][n];
            S[m][n] = result;
            return result;
        }
        result = returnSmall(min(m-1,n,grid)+grid[m][n],min(m,n-1,grid)+grid[m][n]);
        S[m][n] = result;
        return result;
    }

    int returnSmall(int a,int b){
        if (a<b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        int[][] c = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        Q64 q64 = new Q64();
        int i = q64.minPathSum(c);
        System.out.printf("i" + i);
    }
}
