/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-11 17:14
 * @Description:
 */
public class Q887 {
    public int superEggDrop(int K, int N) {

        int dp[][] = new int[K+1][N+1];
        for (int i=1;i<N+1;i++){
            dp[1][i]=i;
        }
        for (int i=1;i<K+1;i++){
            dp[i][1]=1;
            dp[i][0]=0;
        }
        if (K==1){
            return dp[1][N];
        }
        if (N==0){
            return 0;
        }
        if (N==1){
            return 1;
        }
        return hand1(dp,K,N);



    }

    private int hand1(int [][] dp,int k,int n){
        if (k==1){
            return dp[1][n];
        }
        if (n==0){
            return dp[k][0];
        }
        if (n==1){
            return dp[k][1];
        }
        if (dp[k][n]!=0){
            return dp[k][n];
        }
        int min = Integer.MAX_VALUE;
        for (int x=1;x<=n;x++){
            int max = Math.max(hand1(dp, k - 1, x - 1), hand1(dp, k, n - x));
            if (max<min){
                min=max;
            }

        }
        dp[k][n]=1+min;
        return dp[k][n];
    }

    private int hand(int[][] dp,int k,int n){

        if (k==1){
            return dp[1][0];
        }
        if (n==0){
            return dp[k][0];
        }
        if (n==1){
            return dp[k][1];
        }
        if (dp[k][n]!=0){
            return dp[k][n];
        }
        int half = (1+n)/2;
        int t1 = hand(dp,k-1,half-1);
        int t2 = hand(dp,k,n-half);






        return dp[k][n];
    }

    public static void main(String[] args) {
        leecode.Q887 q887 = new leecode.Q887();
        int i = q887.superEggDrop(6, 5000);
        System.out.println(i);

    }
}
