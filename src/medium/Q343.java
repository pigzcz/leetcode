package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/30 11:49
 * @Description:
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Q343 {
    public int integerBreak(int n) {
        int[] s = new int[n+1];
        if(n == 2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        s[2] = 2;
        s[3] = 3;

        for (int i=4;i<=n;i++){
            int j=2;
            int k = i-j;
            int max =0;
            while (j<=k){
                max = Math.max(max,s[j]*s[k]);
                j++;
                k--;
            }
            s[i]=max;

        }
        return s[n];
    }

    public static void main(String[] args) {
        Q343 q343 = new Q343();
        int i = q343.integerBreak(6);
        System.out.println(i);
    }
}
