package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/8 16:29
 * @Description:
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Q77 {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> tmp = new LinkedList<>();
        doCombine(tmp,1,n,k);
        return result;
    }
    void doCombine(LinkedList<Integer> tmp,int start,int n, int k){
        if (tmp.size()+n-start+1 < k){
            return;
        }
        if (tmp.size() == k){
            result.add(new LinkedList<>(tmp));
            return;
        }
        for (int i=start;i<=n;i++){
            tmp.add(i);
            doCombine(tmp,i+1,n,k);
            tmp.removeLast();
        }
    }
}
