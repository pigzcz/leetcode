/**
 * @Auther: johnson.zhu
 * @Date: 2020-03-27 15:48
 * @Description:
 */
public class Q994 {
    public int orangesRotting(int[][] grid) {
        int min=0;
        int noFreshFlag = 2;
        boolean find = true;
        while (find){
            find = false;
            for (int i=0;i<grid.length;i++){
                int[] ydata = grid[i];
                for (int j=0;j<ydata.length;j++){
                    if (grid[i][j]>=2 &&grid[i][j]<=noFreshFlag){
                        if (i-1>=0){
                            if (grid[i-1][j]==1){
                                grid[i-1][j]=noFreshFlag+1;
                                find =true;
                            }
                        }
                        if (i+1<grid.length){
                            if (grid[i+1][j]==1){
                                grid[i+1][j]=noFreshFlag+1;
                                find =true;
                            }
                        }
                        if (j-1>=0){
                            if (grid[i][j-1]==1){
                                grid[i][j-1]=noFreshFlag+1;
                                find =true;
                            }
                        }
                        if (j+1<ydata.length){
                            if (grid[i][j+1]==1){
                                grid[i][j+1]=noFreshFlag+1;
                                find =true;
                            }
                        }

                    }
                }
            }
            if (find){
                min++;
            }
            noFreshFlag++;
        }
        if (!find){
            for (int i=0;i<grid.length;i++){
                int[] ydata = grid[i];
                for (int j=0;j<ydata.length;j++){
                    if (grid[i][j]==1){
                        return -1;
                    }
                }
            }
            return min;
        }
        return 0;
    }


    public int[] distributeCandies(int candies, int num_people) {
        int[] candi = new int[num_people];
        int cur = 0;
        int curCount=1;
        while (candies>0){
            if (candies-curCount>=0){
                candi[cur] = candi[cur]+curCount;
                candies = candies-curCount;
                cur++;
                curCount++;
                if (cur>=num_people){
                    cur=0;
                }

            } else {
                candi[cur]=candi[cur]+candies;
                candies=0;
            }

        }
        return candi;
    }

    public int[] twoSum(int[] nums, int target) {
        return null;
    }
}
