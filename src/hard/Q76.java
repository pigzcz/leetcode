package hard;



import java.util.*;


/**
 * @author:johnson.zhu
 * @Date: 2021/5/15 4:59 下午
 * @Description:
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 **/
public class Q76 {
    /**
     * 滑动窗口
     * 维护一个区间，如果这个区间构成的字符串包含t的所有字符，那么左索引+1,此时在计算满不满足他条件，如果满足继续左索引+1，不满足的话
     * 右索引+1，然后再判断
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char tmp : chars){
            Integer integer = need.get(tmp);
            if (null == integer){
                integer = 1;
            } else {
                integer = integer+1;
            }
            need.put(tmp,integer);
        }
        int needValue = need.keySet().size();
        int tmpValue = 0;
        char[] data = s.toCharArray();
        Map<Character,Integer> window = new HashMap<>();
        int left=0;int right=0;
        String res = "";
        int min = Integer.MAX_VALUE;
        if (need.containsKey(data[0])){
            Integer integer = window.getOrDefault(data[0],0);
            integer=integer+1;
            window.put(data[0],integer);
            if (need.get(data[0]).equals(integer)){
                tmpValue++;
                if (tmpValue==needValue){
                    if (right-(left-1)<min){
                        res = new String(data,left,right-(left-1));
                        min = right-(left-1);
                    }
                }
            }
        }
        while (right<data.length){
            if (tmpValue<needValue){
                right = right+1;
                if (right == data.length){
                    break;
                }
                if (need.containsKey(data[right])){
                    Integer in = window.getOrDefault(data[right], 0);
                    in=in+1;
                    window.put(data[right],in);
                    if (need.get(data[right]).equals(in)){
                        tmpValue++;
                        if (tmpValue==needValue){
                            if (right-(left-1)<min){
                                res = new String(data,left,right-(left-1));
                                min = right-(left-1);
                            }
                        }
                    }
                }
                continue;
            }
            if (tmpValue==needValue){
                if (need.containsKey(data[left])){
                    Integer integer = window.get(data[left]);
                    integer=integer-1;
                    window.put(data[left],integer);
                    if (integer.equals(need.get(data[left])-1)){
                        tmpValue--;
                    } else if (tmpValue == needValue){
                        if (right-left<min){
                            res = new String(data,left+1,right-left);
                            min = right-left;
                        }
                    }
                }else {
                    if (right-left<min){
                        res = new String(data,left+1,right-left);
                        min = right-left;
                    }
                }
                left=left+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q76 q76= new Q76();
        String s = q76.minWindow2("ADOBECODEBANC", "ABC");


        System.out.println(s);
    }

    public String minWindow2(String s, String t) {
        String min = "";
        Map<Character, Integer> needMap = new HashMap<>();
        char[] sarry = s.toCharArray();
        char[] needArray = t.toCharArray();
        for (Character tmp : needArray) {
            needMap.put(tmp, needMap.getOrDefault(tmp, 0) + 1);
        }


        Map<Character, Integer> targetMap = new HashMap<>();
        Set<Character> targetSize = new HashSet<>();
        StringBuilder target = new StringBuilder();
        int i =0;
        int j = 0;
        while (i<s.length()) {
            if(j == s.length()) {
                break;
            }
            if(needMap.containsKey(sarry[j])) {
                int singleTargetSize = targetMap.getOrDefault(sarry[j],0);
                singleTargetSize ++ ;
                targetMap.put(sarry[j], singleTargetSize);
                if(singleTargetSize == needMap.get(sarry[j]) ) {
                    targetSize.add(sarry[j]);
                }
            }

            target.append(sarry[j]);
            if(targetSize.size() < needMap.size()) {
                j ++ ;
            }

            while(targetSize.size() == needMap.size()) {

                if(min.equals("") || min.length() > target.length() -i - 1) {
                    min = target.substring(i, target.length());
                }
                if(needMap.containsKey(sarry[i])) {
                    int tmpSize = targetMap.get(sarry[i]) -1;
                    if(tmpSize < needMap.get(sarry[i])) {
                        targetSize.remove(sarry[i]);
                        j++;
                    }
                    targetMap.put(sarry[i], tmpSize);
                }

                i++;

            }
        }
        return min;
    }

    private boolean contains(Map<Character, Integer> needMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> entry : needMap.entrySet()) {
            Integer target = targetMap.get(entry.getKey());
            if (target == null || target.intValue() < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
