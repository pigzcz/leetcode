package hard;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-06 08:57
 * @Description:
 *
 * 编辑距离
 *
 * acb
 * ac
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

    public int minDistance2(String word1, String word2) {

        char[] a1 = word1.toCharArray();
        char[] a2 = word2.toCharArray();
        int[][] dp = new int[a1.length][a2.length];
        return dp(a1, a2, word1.length()-1, word2.length()-1, dp);
    }
    private int dp(char[] w1, char[] w2, int i, int j, int[][] dp) {

        //如果i是-1，则代表需要补全j个字符
        if (i == -1) {
            return j+1;
        }
        //如果j是-1，则代表需要补全i个字符
        if(j == -1) {
            return i+1;
        }
        if(dp[i][j]  !=0) {
            return dp[i][j];
        }
        //如果字符相等，则代表和i和j都前移一个
        if(w1[i] == w2[j]) {
            dp[i][j] = dp(w1, w2, i-1 ,j-1, dp);
            return dp[i][j];
        } else {
            //如果不相等，则代表可能是代表删除、变化、插入了一个字符,从这几个操作里面选一个最小值
            dp[i][j] = min(dp(w1, w2, i-1 ,j, dp) + 1, dp(w1, w2, i ,j-1, dp) +1 ,dp(w1, w2, i-1 ,j-1, dp) +1);
            return dp[i][j];
        }
    }

    private int min(int a,int b,int c){
        int min = Math.min(a, b);
        min = Math.min(min,c);
        return min;
    }

    public static void main(String[] args) {
        Q72 q72 = new Q72();
        int i = q72.minDistance2("a", "ab");
        System.out.println(i);

    }
}
