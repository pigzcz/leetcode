package medium;

import java.util.Map;

/**
 * @author:johnson.zhu
 * @Date: 2021/4/29 4:39 下午
 * @Description:
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 **/
public class Q633 {
    public boolean judgeSquareSum(int c) {
        for (int a=0;a*a<=c;a++){
            double b = Math.sqrt(c-a*a);
            if (b == (int)b){
                return true;
            }
        }
        return false;
    }
}
