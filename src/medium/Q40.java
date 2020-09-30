package medium;

import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/10 10:50
 * @Description:
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Q40 {
    private List<List<Integer>> res;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        res = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        /**
         * 排序
         */
        Arrays.sort(candidates);
        doCombinationSum(candidates,target,0,candidates.length,0,tmp);
        return res;
    }

    private void doCombinationSum(int[] candidates, int target, int start, int end, int current, LinkedList<Integer> list){
        if(current == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if (current > target){
            return;
        }

        List<Integer> al = new ArrayList<>();
        for (int i= start;i<end;i++){
            if (al.size() != 0){
                if (candidates[i] == al.get(al.size()-1)){
                    continue;
                }
            }
            current = current + candidates[i];
            list.add(candidates[i]);
            al.add(candidates[i]);
            doCombinationSum(candidates, target, i+1, end, current, list);
            current = current - candidates[i];
            list.removeLast();
        }
    }
}
