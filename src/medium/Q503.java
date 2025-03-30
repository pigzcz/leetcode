package medium;

import easy.Q496;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 代码
 测试用例
 测试结果
 测试结果
 503. 下一个更大元素 II
 中等
 相关标签
 相关企业
 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。



 示例 1:

 输入: nums = [1,2,1]
 输出: [2,-1,2]
 解释: 第一个 1 的下一个更大的数是 2；
 数字 2 找不到下一个更大的数；
 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 示例 2:

 输入: nums = [1,2,3,4,3]
 输出: [2,3,4,-1,4]


 提示:

 1 <= nums.length <= 104
 -109 <= nums[i] <= 109
 */
public class Q503 {
    /**
     * 解法单调栈，参考Q496
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] nums2 = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();

        //先都压入栈中
        for(int i=nums.length-1;i>=0;i--) {
            stack.add(nums[i]);
        }

        for(int i=nums.length-1;i>=0;i--) {
            while(!stack.isEmpty() && stack.getLast() <= nums[i]) {
                stack.removeLast();
            }
            if(!stack.isEmpty()) {
                nums2[i] = stack.getLast();
            } else {
                nums2[i] = -1;
            }
            stack.add(nums[i]);
        }
        return nums2;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};

        Q503 q503 = new Q503();
        int[] ints = q503.nextGreaterElements(nums1);
        System.out.println(ints);
    }
}
