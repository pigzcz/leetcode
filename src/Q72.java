/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-06 08:57
 * @Description:
 */
public class Q72 {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        if (n*m==0){
            return n+m;
        }

        int[][]dp=new int[n+1][m+1];
        for (int i=0;i<n+1;i++){
            dp[i][0]=i;
        }
        for (int i=0;i<m+1;i++){
            dp[0][i]=i;
        }
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if (words1[i-1]==words2[j-1]){
                    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]);
                } else {
                    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }

        return dp[n][m];

    }

    private int min(int a,int b,int c){
        int min = Math.min(a, b);
        min = Math.min(min,c);
        return min;
    }

    public static void main(String[] args) {
        leecode.Q72 q72 = new leecode.Q72();
        int i = q72.minDistance("horse", "ros");
        System.out.println(i);

    }
}
