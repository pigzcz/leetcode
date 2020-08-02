package medium;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Q416 {
    /**
     * 关键点，如果能划分成一半一半，那么每一半一定是sum/2 一开始居然把这个给忘了。服了
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if (sum%2!=0){
            return false;
        }
        int half = sum/2;
        int[][] dp = new int[half+1][nums.length];
        return dp(half,nums.length-1,nums,dp);
    }
    boolean dp(int sum,int index,int nums[],int[][]dp){
        if (sum == nums[index]){
            dp[sum][index]=1;
            return true;
        }
        return realdp(sum-nums[index],index-1,nums,dp);

    }
    boolean realdp(int sum,int index,int nums[],int[][]dp){

        if (index<0 ||sum<0){
            return false;
        }
        if (dp[sum][index]!=0){
            return dp[sum][index]==1;
        }
        if (sum == nums[index]){
            dp[sum][index] = 1;
            return true;
        }
        boolean b = realdp(sum, index - 1, nums,dp) || realdp(sum - nums[index], index - 1, nums,dp);
        dp[sum][index]=b==true?1:2;
        return b;
    }

    public static void main(String[] args) {
        int[] ll = new int[]{1,2,3,5,13};
        Q416 q416 = new Q416();
        boolean b = q416.canPartition(ll);
        System.out.println(b);
    }
}
