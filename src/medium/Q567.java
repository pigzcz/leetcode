package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:johnson.zhu
 * @Date: 2021/5/15 6:58 下午
 * @Description:
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 **/
public class Q567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        char[] chars = s1.toCharArray();
        int needLength = chars.length;
        for (char tmp : chars){
            Integer orDefault = need.getOrDefault(tmp, 0);
            orDefault = orDefault+1;
            need.put(tmp,orDefault);
        }

        int left=0;int right=0;
        int needValue = need.size();
        int tmpValue = 0;
        char[] data = s2.toCharArray();
        if (need.containsKey(data[right])){
            Integer orDefault = window.getOrDefault(data[right], 0);
            orDefault+=1;
            window.put(data[right],orDefault);
            if (orDefault.equals(need.get(data[right]))){
                tmpValue++;
            }
            if (tmpValue==needValue && right-(left-1)==needLength){
                return true;
            }
        }

        while (right<s2.length()){
            right++;
            if (right==data.length){
                break;
            }
            if (need.containsKey(data[right])){
                Integer orDefault = window.getOrDefault(data[right], 0);
                orDefault+=1;
                window.put(data[right],orDefault);
                if (orDefault.equals(need.get(data[right]))){
                    tmpValue++;
                }
                if (tmpValue==needValue && right-(left-1)==needLength){
                    return true;
                }
            }
            if (right-left+1>needLength){
                if (need.containsKey(data[left])){
                    Integer integer = window.get(data[left]);
                    integer=integer-1;
                    window.put(data[left],integer);
                    if (integer.equals(need.get(data[left])-1)){
                        tmpValue--;
                    }
                }
                left++;
                if (tmpValue==needValue && right-(left-1)==needLength){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q567 q567 = new Q567();
        boolean b = q567.checkInclusion("ab", "eidboaoo");
        System.out.println(b);
    }
}
