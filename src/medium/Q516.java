package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/31 17:48
 * @Description:
 * 516. 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。

 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 */
public class Q516 {
    public int longestPalindromeSubseq(String s) {
        if (null == s || s.length()==0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        return dp(s,0,s.length()-1,dp);
    }


    public int dp(String s,int start, int end,int[][] dp){
        if (dp[start][end]!=0){
            return dp[start][end];
        }
        if (start==end){
            dp[start][end] = 1;
            return 1;
        }
        if (start>end){
            dp[start][end]=0;
            return 0;
        }
        if (s.charAt(start)==s.charAt(end)){
            int i = dp(s, start + 1, end - 1,dp) + 2;
            dp[start][end] = i;
            return i;
        }
        int max = Math.max(dp(s, start + 1, end,dp), dp(s, start, end - 1,dp));
        dp[start][end] = max;
        return max;
    }

    public static void main(String[] args) {
        Q516 q516 = new Q516();
        int bbbab = q516.longestPalindromeSubseq("cbba");
        System.out.println(bbbab);
    }
}
