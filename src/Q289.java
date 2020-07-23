import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-02 17:03
 * @Description:
 */
public class Q289 {
    public static void gameOfLife(int[][] board) {
        int newHuo = 2;
        int newSi = 3;
        int[][] xl = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        List<int[]> siList = new ArrayList<>();
        List<int[]> huoList = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                int alive=0;
                int dead = 0;
                for (int l=0;l<xl.length;l++){
                    int x=i+xl[l][0];
                    int y = j+xl[l][1];
                    if (x>=0&&x<board.length&&y>=0&&y<board[0].length){
                        if (board[x][y]==0){
                            dead++;
                        }
                        if (board[x][y]==1){
                            alive++;
                        }

                    }
                }


                if (board[i][j]==0){
                    if (alive==3){
                        huoList.add(new int[]{i,j});
                    }
                }
                if (board[i][j]==1){
                    if (alive<2||alive>3){
                        siList.add(new int[]{i,j});
                    }
                }
            }
        }

        for (int[] huo : huoList){
            board[huo[0]][huo[1]]=1;
        }
        for (int[]si:siList){
            board[si[0]][si[1]]=0;
        }

    }

    public static void main(String[] args) {
        int[][] xl = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(xl);
    }
}
