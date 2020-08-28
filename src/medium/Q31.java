package medium;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Q31 {
    public void nextPermutation(int[] nums) {

        int index = -1;
        for (int k = nums.length-2;k>=0;k--){
            int min = Integer.MAX_VALUE;
            int kk = -1;
            for (int l = nums.length-1;l>k;l--){
                if (nums[l]>nums[k]){
                    if (nums[l]<min){
                        kk = l;
                        min = nums[l];
                    }
                }
            }
            if (kk!=-1){
                nums[kk]=nums[k];
                nums[k] = min;
                index=k;
                break;
            }

        }
        Arrays.sort(nums,index+1,nums.length);
    }


    public static void main(String[] args) {
        int[] a = new int[]{2,3,1};
        Q31 q31 = new Q31();
        q31.nextPermutation(a);
        System.out.println(a);
    }
}
