package hard;

import java.util.Arrays;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/11/26 10:30
 * @Description:
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length ==0 || nums.length == 1){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int last = nums[0];
        for (int i=1;i<nums.length;i++){
            int c = nums[i]-last;
            if (c>max){
                max = c;
            }
            last = nums[i];
        }
        return max;

    }
}
