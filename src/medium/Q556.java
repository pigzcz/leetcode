package medium;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q556 {
    /**
     * 556. 下一个更大元素 III
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
     *
     * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 12
     * 输出：21
     * 示例 2：
     *
     * 输入：n = 21
     * 输出：-1
     *
     *
     * 提示：
     *
     * 1 <= n <= 231 - 1
     */
    public int nextGreaterElement(int n) {
        String string = String.valueOf(n);
        char[] chars = string.toCharArray();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int index = 0;
        Integer current = null;
        Integer tmpHigh = null;
        for (int i = chars.length-1;i>=0;i--) {
            String tmp = String.valueOf(chars[i]);
            Integer orDefault = treeMap.getOrDefault(Integer.valueOf(tmp), 0);
            //如果当前的元素之前没有并且之前不是空的
            if (!treeMap.isEmpty()) {
                Integer integer = treeMap.higherKey(Integer.valueOf(tmp));
                //找到了比他大的最小数
                if (integer != null) {
                    current = Integer.valueOf(tmp);
                    tmpHigh = integer;
                    index = i;
                    treeMap.put(current, orDefault+1);
                    break;
                }
            }
            treeMap.put(Integer.valueOf(tmp), orDefault+1);
            index = i;
        }
        if (null == current) {
            return -1;
        }
        //最小数

        Integer size = treeMap.get(tmpHigh);
        if(size-1>0) {
            treeMap.put(tmpHigh,size-1);
        }else {
            treeMap.remove(tmpHigh);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<index;i++) {
            sb.append(chars[i]);
        }
        sb.append(tmpHigh);
        for (Map.Entry<Integer, Integer> tmp : treeMap.entrySet()) {
            Integer value = tmp.getValue();
            for (int k = 0;k<value;k++) {
                sb.append(tmp.getKey());
            }
        }
        try {
            return Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Integer integer23 = treeMap.lowerKey(2);
        System.out.println(integer23);
        treeMap.put(1,1);
        treeMap.put(3,3);
        treeMap.put(2,2);
        treeMap.put(5,5);
        treeMap.put(1,1);
        Integer integer = treeMap.lastKey();
        Integer integer1 = treeMap.firstKey();
        System.out.println(integer);
        Integer integer2 = treeMap.higherKey(5);
        System.out.println(integer2);
//        Integer integer3 = Integer.valueOf("5555555555555555555555555555555555555555555555555555555555555555555");
        for (Map.Entry<Integer, Integer> tmp : treeMap.entrySet()) {
            System.out.println(tmp);
        }
        Q556 q556 = new Q556();
        int i = q556.nextGreaterElement(12443322);
        System.out.println(i);
    }
}
