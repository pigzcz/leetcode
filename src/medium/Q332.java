package medium;

import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/31 18:01
 * @Description:
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 *
 *
 * 提示：
 *
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *
 *
 * 示例 1：
 *
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 *
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (List<String> tmp : tickets){
            LinkedList<String> strings = map.get(tmp.get(0));
            if (null == strings){
                strings = new LinkedList<>();
                map.put(tmp.get(0),strings);
            }
            strings.add(tmp.get(1));
        }
        for (Map.Entry<String,LinkedList<String>> entry : map.entrySet()){
            List<String> value = entry.getValue();
            value.sort(String::compareTo);
        }
        List<String> result = new ArrayList<>();

        String start = "JFK";
        result.add(start);
        for (LinkedList<String> tt = map.get(start);null != tt &&tt.size() !=0 ;tt=map.get(start)){
            String s = tt.pollFirst();
            result.add(s);
            start = s;
        }
        return result;
    }
    public static void main(String[] args) {
//输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        List<List<String>> re = new ArrayList<>();
        List<String> a1 = new ArrayList<>();
        a1.add("MUC");a1.add("LHR");
        re.add(a1);
        List<String> a2 = new ArrayList<>();
        a2.add("JFK");a2.add("MUC");
        re.add(a2);
        List<String> a3 = new ArrayList<>();
        a3.add("SFO");a3.add("SJC");
        re.add(a3);
        List<String> a4 = new ArrayList<>();
        a4.add("LHR");a4.add("SFO");
        re.add(a4);
        Q332 q332 = new Q332();
        List<String> itinerary = q332.findItinerary(re);

    }
}
