package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-25 08:13
 * @Description:
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Q46 {


    public List<List<Integer>> permute(int[] nums) {
        if (null == nums||nums.length==0){
            return null;
        }
        List<List<Integer>> re = new ArrayList<>();
        LinkedList<Integer> init = new LinkedList<>();
        init.add(nums[0]);
        re.add(init);
        for (int i=1 ;i<nums.length;i++){

            List<List<Integer>> t = new ArrayList<>();
            for (List<Integer> tmp :  re){
                for (int j=0;j<=tmp.size();j++){
                    LinkedList tmp1 = (LinkedList) tmp;
                    LinkedList clone = (LinkedList)tmp1.clone();
                    clone.add(j,nums[i]);
                    t.add(clone);
                }

            }
            re = t;
        }
        return re;
    }


    public static void main(String[] args) {
        int[] x= new int[]{1,2,3};
        Q46 q46 = new Q46();
        List<List<Integer>> permute = q46.permute(x);
        System.out.println(permute);
    }

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute2(int[] nums) {
        LinkedList<Integer> tmp = new LinkedList<>();
        doPermute(nums,tmp);
        return res;
    }
    public void doPermute(int[] nums,LinkedList<Integer> tmp){
        if (nums.length == tmp.size()){
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (tmp.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            doPermute(nums,tmp);
            tmp.removeLast();
        }
    }
}
