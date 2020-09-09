package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/9 14:19
 * @Description:
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Q39 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        doCombinationSum(candidates,target,0,candidates.length,0,tmp);
        return res;
    }
    private boolean doCombinationSum(int[] candidates, int target, int start, int end, int current, LinkedList<Integer> list){
        if(current == target){
            res.add(new ArrayList<>(list));
            return false;
        }
        if (current > target){
            return false;
        }

        for (int i= start;i<end;i++){
            current = current + candidates[i];
            list.add(candidates[i]);
            boolean b = doCombinationSum(candidates, target, i, end, current, list);
            current = current - candidates[i];
            list.removeLast();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{8,7,4,3};
        Q39 q39 = new Q39();
        List<List<Integer>> lists = q39.combinationSum(tmp, 11);
        System.out.println(lists);
        int i=0;
        for (;i<100;i+=10){
            System.out.println(i);
        }
    }
}
