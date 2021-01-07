package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/11/26 11:21
 * @Description:
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 */
public class Q1370 {

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        for (char c : chars){
            int k = (int)c;
            Integer integer = map.get(k);
            if(null == integer){
                integer = 0;
            }
            integer = integer + 1;
            map.put(k,integer);
        }
        StringBuilder builder = new StringBuilder();
        for (int i=61;i<123;i++){
            Integer integer = map.get(i);
            if (null != integer){
                for (int j=0;j<integer;j++){
                    builder.append((char)i);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Q1370 q1370 = new Q1370();
        String leetcode = q1370.sortString("leetcode");
        System.out.println(leetcode);
    }
}
