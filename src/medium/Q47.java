package medium;

import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/18 09:48
 * @Description:
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> f = new LinkedList<>();
        f.add(nums[0]);
        res.add(f);
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i=1;i<nums.length;i++){
            for (List<Integer> tt : res){
                List<LinkedList<Integer>> add = add(nums[i], tt);
                tmp.addAll(add);
            }
            res = tmp;
            tmp = new ArrayList<>();
        }
        return res;
    }
    public List<LinkedList<Integer>> add(int num, List<Integer> org){
        LinkedList<Integer> ori = (LinkedList<Integer>) org;
        List<LinkedList<Integer>> res = new ArrayList<>();
        int i=0;
        Set<Integer> indexs = new HashSet<>();
        indexs.add(0);
        for (Integer tmp : ori){
            if (tmp.equals(num)){
                indexs.remove(i);
                indexs.add(i+1);
            } else {
                indexs.add(i+1);
            }
            i++;
        }
        for (Integer index : indexs){
            LinkedList clone = (LinkedList)ori.clone();
            if (index == ori.size()){
                clone.addLast(num);
                res.add(clone);
            } else {
                clone.add(index,num);
                res.add(clone);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q47 q47 = new Q47();
        int[] nums = new int[]{2,2,1,1};
        List<List<Integer>> lists = q47.permuteUnique(nums);
        System.out.println(lists);
    }
}
