package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/30 17:29
 * @Description:
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Q309 {
    /**
     * 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]f[i][0]；
     *
     * 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]f[i][1]；
     *
     * 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]f[i][2]。
     *对于 f[i][0]f[i][0]，我们目前持有的这一支股票可以是在第 i-1i−1 天就已经持有的，对应的状态为 f[i-1][0]f[i−1][0]；或者是第 ii 天买入的，那么第 i-1i−1 天就不能持有股票并且不处于冷冻期中，对应的状态为 f[i-1][2]f[i−1][2] 加上买入股票的负收益 {\it prices}[i]prices[i]。因此状态转移方程为：
     *
     * f[i][0] = \max(f[i-1][0], f[i-1][2] - {\it prices}[i])
     * f[i][0]=max(f[i−1][0],f[i−1][2]−prices[i])
     *
     * 对于 f[i][1]f[i][1]，我们在第 ii 天结束之后处于冷冻期的原因是在当天卖出了股票，那么说明在第 i-1i−1 天时我们必须持有一支股票，对应的状态为 f[i-1][0]f[i−1][0] 加上卖出股票的正收益 {\it prices}[i]prices[i]。因此状态转移方程为：
     *
     * f[i][1] = f[i-1][0] + {\it prices}[i]
     * f[i][1]=f[i−1][0]+prices[i]
     *
     * 对于 f[i][2]f[i][2]，我们在第 ii 天结束之后不持有任何股票并且不处于冷冻期，说明当天没有进行任何操作，即第 i-1i−1 天时不持有任何股票：如果处于冷冻期，对应的状态为 f[i-1][1]f[i−1][1]；如果不处于冷冻期，对应的状态为 f[i-1][2]f[i−1][2]。因此状态转移方程为：
     *
     * f[i][2] = \max(f[i-1][1], f[i-1][2])
     * f[i][2]=max(f[i−1][1],f[i−1][2])
     *
     * 这样我们就得到了所有的状态转移方程。如果一共有 nn 天，那么最终的答案即为：
     *
     * \max(f[n-1][0], f[n-1][1], f[n-1][2])
     * max(f[n−1][0],f[n−1][1],f[n−1][2])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] s = new int[prices.length][3];
        s[0][0] = -prices[0];
        s[0][1] = 0;
        s[0][2] = 0;
        for (int i = 1;i<prices.length;i++){
            s[i][0] = Math.max(s[i-1][0],s[i-1][2]-prices[i]);
            s[i][1] = s[i-1][0] + prices[i];
            s[i][2] = Math.max(s[i-1][1],s[i-1][2]);
        }

        return Math.max(s[prices.length-1][2],Math.max(s[prices.length-1][0],s[prices.length-1][1]));
    }
}
