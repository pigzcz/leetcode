package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/31 14:41
 * @Description:
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int allMax =1;
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int i=1;i<n;i++){
            int max = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
            allMax = Math.max(max,allMax);
        }
        return allMax;
    }

    public int lengthOfLIS2(int[] nums) {
        if(null == nums) {
            return 0;
        }
        if(nums.length==1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            dp[i]=1;
        }
        int allMax = 1;
        for(int i=1;i<nums.length;i++) {
            int max = 1;
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] ) {
                    max = Math.max(dp[j] + 1, max);
                    dp[i] = max;
                    allMax = Math.max(max, allMax);
                }
            }
        }
        return allMax;
    }
    public static void main(String[] args) {
        int[] m = new int[]{1,3,6,7,9,4,10,5,6};
        Q300 q300 = new Q300();
        int i = q300.lengthOfLIS(m);

        int[] m1 = new int[]{10,9,2,5,3,7,101,18};
        int i1 = q300.lengthOfLIS2(m1);
        System.out.println(i);
    }
}
