import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q322 {
    public static int coinChange(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        Set<Integer> coinSet = new HashSet<>();
        for (int i=0;i<coins.length;i++){
            coinSet.add(coins[i]);
        }

        int[] s = new int[amount];
        for (int i=1;i<=amount;i++){
            if (coinSet.contains(i)){
                s[i-1]=1;
            }else {
                int tmpMin =Integer.MAX_VALUE;
                for (int j=1;j<=i/2;j++){
                    if (s[j-1]>0&&s[i-j-1]>0){
                        if (s[j-1]+s[i-j-1]<tmpMin){
                            tmpMin=s[j-1]+s[i-j-1];
                        }


                    }
                }
                if (tmpMin<Integer.MAX_VALUE){
                    s[i-1]=tmpMin;
                } else {
                    s[i-1]=-1;
                }


            }
        }
        return s[amount-1];

    }

    public static int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] c = new int[]{139,442,147,461,244,225,28,378,371};
        int i = coinChange(c, 9914);
        int j = coinChange1(c,9914);
        System.out.println(i);
        System.out.println(j);
    }
}
