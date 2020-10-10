package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/10/4 12:25
 * @Description:
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> index = new HashMap<>(nums.length);
        Map<Integer,Integer> chongfu = new HashMap<>(nums.length);
        for (int i=0;i<nums.length ;i++){
            if (!index.containsKey(nums[i])){
                index.put(nums[i],i);
            } else {
                chongfu.put(nums[i],i);
            }
        }

        for (Map.Entry<Integer,Integer> entry : index.entrySet()){
            int t1 = entry.getKey();
            int t2 = target - t1;
            if (t2 == t1){
                if (chongfu.containsKey(t2)){
                    return new int[]{entry.getValue(),chongfu.get(t2)};
                }
            }
            if (index.containsKey(t2)){
                return new int[]{entry.getValue(),index.get(t2)};
            }
        }
        return null;
    }
}
