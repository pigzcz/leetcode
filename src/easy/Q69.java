package easy;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/8 17:27
 * @Description:
 *  x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Q69 {
    public int mySqrt(int x) {
        for(int i=0;i<=x;i++){
            int k = i*i;
            if(k==x){
                return i;
            }
            if(k>x || k<0){
                return i-1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Q69 q69 = new Q69();
        System.out.println(46341*46341);
        int i = q69.mySqrt(2147483647);

        System.out.println(i);
    }
}
