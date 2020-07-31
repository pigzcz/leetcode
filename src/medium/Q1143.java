package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/31 10:57
 * @Description:
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 */
public class Q1143 {
    private int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        return dp(text1,text2,text1.length(),text2.length());
    }
    public int dp(String text1,String text2,int i, int j){
        if (dp[i][j]!=0){
            return dp[i][j];
        }
        if (i==0 || j==0){
            if (i==0){
                dp[0][j]=0;
            }
            if (j==0){
                dp[i][0]=0;
            }
            return 0;
        }
        if (text1.charAt(i-1)==text2.charAt(j-1)){
            int i1 = dp(text1, text2, i - 1, j - 1) + 1;
            dp[i][j] = i1;
            return i1;
        }
        int max = Math.max(dp(text1, text2, i - 1, j), dp(text1, text2, i, j - 1));
        dp[i][j] = max;
        return max;
    }
}
