package medium;

import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2021/1/6 17:37
 * @Description:
 * 399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 *
 *
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * 提示：
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 */
public class Q399 {
    private Map<String, Map<String,Double>> headMap = new HashMap<>();
//    private Map<String, Map<String,Double>> tailMap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0;
        for (List<String> tmp : equations){
            Node node = new Node(tmp.get(0),tmp.get(1),values[i]);
            put(node);
            handle(node);
            i++;
        }

        double[] res = new double[queries.size()];
        int k =0;
        for (List<String> tmp : queries){
            String head = tmp.get(0);
            String tail = tmp.get(1);
            Map<String, Double> headValue = headMap.get(head);
            if (null != headValue){
                if (head.equals(tail)){
                    res[k++]=1d;
                    continue;
                }
                Double aDouble = headValue.get(tail);
                if (null != aDouble){
                    res[k++]=aDouble;
                    continue;
                }
            }
            res[k++]=-1d;
        }
        return res;
    }



    public void put(Node node){
        Map<String, Double> headValue = headMap.get(node.head);
        if (null == headValue){
            headValue = new HashMap<>();
            headMap.put(node.head,headValue);
        }
        headValue.put(node.tail,node.value);
        Map<String, Double> headTailValue = headMap.get(node.tail);
        if (null == headTailValue){
            headTailValue = new HashMap<>();
            headMap.put(node.tail,headTailValue);
        }
        headTailValue.put(node.head,1/node.value);

//        Map<String, Double> tailValue = tailMap.get(node.tail);
//        if (null == tailValue){
//            tailValue = new HashMap<>();
//            tailMap.put(node.tail,tailValue);
//        }
//        tailValue.put(node.head,node.value);
//
//        Map<String, Double> tailHeadValue = tailMap.get(node.head);
//        if (null == tailHeadValue){
//            tailHeadValue = new HashMap<>();
//            tailMap.put(node.head,tailHeadValue);
//        }
//        tailHeadValue.put(node.tail,1/node.value);
    }

    public void handle(Node tmp){
        if (null == tmp){
            return;
        }
        List<Node> res = new ArrayList<>();
        Map<String, Double> tailHeadValue = headMap.get(tmp.head);
        if (null != tailHeadValue){
            for (Map.Entry<String,Double> entry : tailHeadValue.entrySet()){
                String key = entry.getKey();
                Double value = entry.getValue();
                if (!key.equals(tmp.tail)){
                    Node node = new Node(key,tmp.tail,1/value*tmp.value);
                    Map<String, Double> stringDoubleMap = headMap.get(node.head);
                    if (null != stringDoubleMap && stringDoubleMap.containsKey(node.tail)){
                        continue;
                    }
                    res.add(node);
//                    put(node);
//                    handle(node);
                }
            }
        }

        Map<String, Double> ttvalue = headMap.get(tmp.tail);
        if (null != ttvalue){
            for (Map.Entry<String,Double> entry : ttvalue.entrySet()){
                String key = entry.getKey();
                Double value = entry.getValue();
                if (!key.equals(tmp.head)){
                    Node node = new Node(tmp.head,key,value*tmp.value);
                    Map<String, Double> stringDoubleMap = headMap.get(node.head);
                    if (null != stringDoubleMap && stringDoubleMap.containsKey(node.tail)){
                        continue;
                    }
                    res.add(node);
//                    put(node);
//                    handle(node);
                }
            }
        }
        for (Node n : res){
            put(n);
            handle(n);
        }
    }




    public static class Node{
        public String head;
        public String tail;
        public double value;

        public Node(String head, String tail, double value) {
            this.head = head;
            this.tail = tail;
            this.value = value;
        }
    }






    public static void main(String[] args) {
        List<List<String>> q = new ArrayList<>();
        q.add(Arrays.asList("a","b"));
        q.add(Arrays.asList("e","f"));
        q.add(Arrays.asList("b","e"));
        double[] values = new double[]{3.4d,1.4d,2.3d};
        List<List<String>> a = new ArrayList<>();
        a.add(Arrays.asList("b","a"));
        a.add(Arrays.asList("a","f"));
        a.add(Arrays.asList("f","f"));
        a.add(Arrays.asList("e","e"));
        a.add(Arrays.asList("c","c"));
        a.add(Arrays.asList("a","c"));
        a.add(Arrays.asList("f","e"));

        Q399 q399 = new Q399();
        double[] doubles = q399.calcEquation(q, values, a);
        System.out.println(doubles);
    }
}
