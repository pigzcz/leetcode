package medium;

import java.util.*;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Q78 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        Set<Integer> al = new HashSet<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        doSubsets(nums,al,tmp,0);
        return res;
    }

    private void doSubsets(int[] nums, Set<Integer> al, LinkedList<Integer> tmp,int start){
        for (int i=start;i<nums.length;i++){
            int t = nums[i];
            if (!al.contains(t)){
                tmp.add(t);
                res.add(new ArrayList<>(tmp));
                al.add(t);
                doSubsets(nums,al,tmp,i+1);
                al.remove(t);
                tmp.removeLast();
            }
        }

    }
}
