package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/11 13:36
 * @Description:
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        doCombinationSum3(res,tmp,k,0,0,n,1);
        return res;
    }
    private void doCombinationSum3(List<List<Integer>> res, LinkedList<Integer> tmp, int k, int tk, int tn, int n,int start){
        if (tk == k){
            if (tn ==n){
                res.add(new LinkedList<>(tmp));
            }
            return;
        }
        for (int i=start;i<=9;i++){
            tmp.add(i);
            tn +=i;
            tk++;
            doCombinationSum3(res,tmp,k,tk,tn,n,i+1);
            tmp.removeLast();
            tn-=i;
            tk--;
        }
    }

    public static void main(String[] args) {
        Q216 q216 = new Q216();
        List<List<Integer>> lists = q216.combinationSum3(3, 9);
        System.out.println(lists);
    }
}
