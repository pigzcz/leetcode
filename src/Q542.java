import java.util.ArrayList;


public class Q542 {
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        int n = matrix[0].length;
        int[][] re = new int[m][n];
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==1){
                    if (i-1>=0){
                        if (matrix[i-1][j]==0){
                            re[i][j]=1;
                            tmp.add(new int[]{i,j});
                            continue;
                        }
                    }
                    if (i+1<m){
                        if (matrix[i+1][j]==0){
                            re[i][j]=1;
                            tmp.add(new int[]{i,j});
                            continue;
                        }
                    }
                    if (j+1<n){
                        if (matrix[i][j+1]==0){
                            re[i][j]=1;
                            tmp.add(new int[]{i,j});
                            continue;
                        }
                    }
                    if (j-1>=0){
                        if (matrix[i][j-1]==0){
                            re[i][j]=1;
                            tmp.add(new int[]{i,j});
                            continue;
                        }
                    }
                }
            }
        }
        int k = 2;
        while (tmp.size()!=0){
            ArrayList<int[]> current = new ArrayList<>();
            for (int[] index:tmp){
                int x =index[0];
                int y = index[1];
                if (x-1>=0){
                    if (matrix[x-1][y]==1 && re[x-1][y]==0){
                        re[x-1][y]=k;
                        current.add(new int[]{x-1,y});
                    }
                }
                if (x+1<m){
                    if (matrix[x+1][y]==1 && re[x+1][y]==0){
                        re[x+1][y]=k;
                        current.add(new int[]{x+1,y});
                    }
                }
                if (y-1>=0){
                    if (matrix[x][y-1]==1 && re[x][y-1]==0){
                        re[x][y-1]=k;
                        current.add(new int[]{x,y-1});
                    }
                }
                if (y+1<n){
                    if (matrix[x][y+1]==1 && re[x][y+1]==0){
                        re[x][y+1]=k;
                        current.add(new int[]{x,y+1});
                    }
                }
            }
            tmp = current;
            k++;
        }
        return re;
    }
}
