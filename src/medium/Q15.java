package medium;

import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/17 20:37
 * @Description:
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (null ==nums || nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        boolean hasLast = false;
        int lasta=0,lastb=0,lastc =  0;
        Set<Integer> set = new HashSet<>(nums.length);
        int i=0;
        while (i<nums.length && nums[i]<=0){
            if (set.contains(nums[i])){
                i++;
                continue;
            } else {
                set.add(nums[i]);
            }
            int j = i+1;
            int k = nums.length-1;
            while (j<nums.length-1){
                while (k>j){
                    if (nums[i]+nums[j]+nums[k]==0){
                        if(!hasLast){
                            List<Integer> ll = new ArrayList<>(3);
                            ll.add(nums[i]);ll.add(nums[j]);ll.add(nums[k]);
                            res.add(ll);
                            hasLast = true;
                            lasta = nums[i];
                            lastb = nums[j];
                            lastc = nums[k];
                            k--;
                            break;
                        }else {
                            if (lasta != nums[i] || lastb != nums[j]){
                                List<Integer> ll = new ArrayList<>(3);
                                ll.add(nums[i]);ll.add(nums[j]);ll.add(nums[k]);
                                res.add(ll);
                                lasta = nums[i];
                                lastb = nums[j];
                                lastc = nums[k];
                                k--;
                                break;
                            } else {
                                break;
                            }
                        }
                    } else if (nums[i]+nums[j]+nums[k]>0){
                        k--;
                    } else if(nums[i]+nums[j]+nums[k]<0){
                        break;
                    }
                }
                j++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Q15 q15 = new Q15();
        List<List<Integer>> lists = q15.threeSum(nums);
        System.out.println(lists);
    }
}
