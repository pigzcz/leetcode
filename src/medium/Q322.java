package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

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

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0]=0;
        /**
         * 因为如果coins里只有1，那么amount金额一定是amount个币组成，所以我们把默认定位amount+1,取的时候和此值比较，小就替换之
         */
        for (int i =1;i<=amount;i++){
            dp[i] = amount +1;
        }
        /**
         * 思路是如果coins[1,2,5]
         * 那么dp[amount] 为min(dp[amount-1]+1,dp[amount-2]+1,dp[amount-5]+1)
         */
        for (int i=1;i<=amount;i++){
            for (int j=0;j<coins.length;j++){
                if (i-coins[j]>=0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);

                }
            }
        }
        return dp[amount] > amount ?-1:dp[amount];
    }




    public static void main(String[] args) {
//        int[] c = new int[]{139,442,147,461,244,225,28,378,371};
        int[] c = new int[]{1,2,5};
        int i = coinChange(c, 9914);
//        int j = coinChange1(c,9914);
        int j = coinChange2(c,11);
        System.out.println(i);
        System.out.println(j);
    }
}
