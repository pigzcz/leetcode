package easy;

/**
 * @author:johnson.zhu
 * @Date: 2021/12/17 12:06 上午
 * @Description:
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 **/
public class Q53 {
    public int maxSubArray(int[] nums) {
        /**
         * dp表示以这个数结尾的最大值
         */
        int[] dp = new int[nums.length];
        int max = nums[0];
        for(int i =0;i<nums.length;i++){
            dp[i] = nums[i];
            max = Math.max(max,nums[i]);
        }
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
