import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-20 13:44
 * @Description:
 */
public class Q200 {
    public int numIslands(char[][] grid) {
        if (grid.length==0||grid[0].length==0){
            return 0;
        }
        int[][] flag = new int[grid.length][grid[0].length];

        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){


                if (grid[i][j]=='1' && flag[i][j]==0){
                    Set<int[]> set = new HashSet<>();
                    set.add(new int[]{i,j});
                    flag[i][j]=1;
                    while (!set.isEmpty()){
                        Set<int[]> tmp = new HashSet<>();
                        for (int[]index : set){
                            int x = index[0];
                            int y = index[1];
                            if (x-1>=0){
                                if (grid[x-1][y]=='1'&& flag[x-1][y]==0){
                                    tmp.add(new int[]{x-1,y});
                                    flag[x-1][y]=1;
                                }
                            }
                            if (x+1<grid.length){
                                if (grid[x+1][y]=='1'&& flag[x+1][y]==0){
                                    tmp.add(new int[]{x+1,y});
                                    flag[x+1][y]=1;
                                }
                            }
                            if (y-1>=0){
                                if (grid[x][y-1]=='1'&&flag[x][y-1]==0){
                                    tmp.add(new int[]{x,y-1});
                                    flag[x][y-1]=1;
                                }
                            }
                            if (y+1<grid[0].length){
                                if (grid[x][y+1]=='1'&&flag[x][y+1]==0){
                                    tmp.add(new int[]{x,y+1});
                                    flag[x][y+1]=1;
                                }
                            }

                        }
                        set = tmp;

                    }
                    count++;


                }
            }
        }
        return count;
    }


}
