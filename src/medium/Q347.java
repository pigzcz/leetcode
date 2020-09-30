package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/7 15:22
 * @Description:
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numScore = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            Integer score = numScore.get(nums[i]);
            if (null == score){
                score = 1;
                numScore.put(nums[i],score);
            } else {
                score++;
                numScore.put(nums[i],score);
            }
        }
        Map<Integer, List<Integer>> scoreNum = new HashMap<>(numScore.size());
        List<Integer> score = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:numScore.entrySet()){
            List<Integer> integers = scoreNum.get(entry.getValue());
            if (null == integers){
                integers = new ArrayList<>();
                scoreNum.put(entry.getValue(),integers);
                score.add(entry.getValue());
            }
            integers.add(entry.getKey());
        }

        score.sort((item,item2)->-1*item.compareTo(item2));
        int cont=0;
        int[] res = new int[k];
         while (cont<k){
            for (Integer s : score){
                List<Integer> integers = scoreNum.get(s);
                for (Integer t : integers){
                    res[cont] = t;
                    cont++;
                    if (cont == k){
                        return res;
                    }
                }
            }
        }
         return res;

    }

    public static void main(String[] args) {
        Q347 q347 = new Q347();
        int[] k = new int[]{4,1,-1,2,-1,2,3};
        int[] ints = q347.topKFrequent(k, 2);
    }
}
