package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 632. 最小区间
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * 示例 1:
 *
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * 注意:
 *
 * 给定的列表可能包含重复元素，所以在这里升序表示 >= 。
 * 1 <= k <= 3500
 * -105 <= 元素的值 <= 105
 * 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
 */
public class Q632 {
    /**
     * 用来标记 归并后的数组[start,end]是否涵盖了所有 nums数组的所有index
     */
    int flag = 0;
    public int[] smallestRange(List<List<Integer>> nums) {

        int min = Integer.MAX_VALUE;
        int[] res = null;
        /**
         * 如果只有1个，直接返回
         */
        if(nums.size() == 1){
            Integer integer = nums.get(0).get(0);
            return new int[]{integer,integer};
        }

        ArrayList<Node> initList = new ArrayList<>(nums.get(0).size()+nums.get(1).size());
        /**
         * 将所有的数组归并成一个
         */
        guibing(nums.get(0),0,nums.get(1),1,initList);
        if (nums.size()!=2){
            for(int i =2;i<nums.size();i++){
                initList = guibing(initList,nums.get(i),i);
            }
        }

        /**
         * 用来表示归并后的数组[start,end] nums 数的个数
         *
         * [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
         * 归并后[0,4,5,9,10,12,15,18,20,22,24,26,30]
         * start=0,end=1时
         * dp数组为[1,1,0]
         * 因为0是0数组的，4是1数组的
         * start=0,end=2
         * dp数组为[1,1,1]
         * 因为0是0数组，4是1数组5是2数组
         * 此时flag=3
         * 表示归并后的数组start到end涵盖 0-2数组的其中数
         */
        int[] dp = new int[nums.size()];


        int start = 0;
        int end = 1;
        addNode(initList.get(0).belongIndex,dp);
        while (flag != nums.size()){
            addNode(initList.get(end).belongIndex,dp);
            end++;
        }
        while (flag == nums.size()){
            deleteNode(initList.get(start).belongIndex,dp);
            start++;
        }
        /**
         * 此时找到了第一个 涵盖所有数组的start和end
         */
        min = initList.get(end-1).value - initList.get(start-1).value;
        res = new int[]{initList.get(start-1).value,initList.get(end-1).value};

        /**
         * 循环遍历 如果end小于归并数组的size，或者 flag标记等于nums的大小
         */
        while (end < initList.size() || flag == nums.size()){
            /**
             * 如果flag不等于nums的大小，我们需要往后加个end
             */
            if (flag != nums.size()){
                addNode(initList.get(end).belongIndex,dp);
                end++;
                continue;
            }
            /**
             * 如果flag等于nums的小小，我们可以把start减去，然后start++
             */
            if (flag == nums.size()){
                int i = initList.get(end-1).value - initList.get(start).value;
                /**
                 * 如果小则替换之前的数据
                 */
                if (i<min){
                    min = i;
                    res = new int[]{initList.get(start).value,initList.get(end-1).value};
                }
                deleteNode(initList.get(start).belongIndex,dp);
                start++;
            }


        }

        return res;

    }
    void addNode(List<Integer> nodeIndexs,int[] dp){
        for (int nodeIndex : nodeIndexs){
            if (dp[nodeIndex] == 0){
                flag++;
            }
            dp[nodeIndex] = dp[nodeIndex]+1;
        }
    }
    void deleteNode(List<Integer> nodeIndexs, int[]dp){
        for (int nodeIndex : nodeIndexs){
            dp[nodeIndex] = dp[nodeIndex]-1;
            if (dp[nodeIndex] ==0){
                flag--;
            }
        }
    }

    ArrayList<Node> guibing(ArrayList<Node> left,List<Integer> right,int rightIndex){
        ArrayList<Node> result = new ArrayList<>(left.size()+right.size());
        int l = 0;
        int r =0;
        while (l<left.size() || r<right.size()){
            if (l>=left.size()){
                result.add(new Node(right.get(r),rightIndex));
                r++;
                continue;
            }
            if (r>=right.size()){
                result.add(left.get(l));
                l++;
                continue;
            }
            if (left.get(l).value==right.get(r).intValue()){
                result.add(left.get(l).linkedNewIndex(rightIndex));
                l++;
                r++;
                continue;
            }
            if (left.get(l).value < right.get(r).intValue()){
                result.add(left.get(l));
                l++;
                continue;
            }
            if (left.get(l).value>right.get(r).intValue()){
                result.add(new Node(right.get(r),rightIndex));
                r++;
                continue;
            }
        }
        return result;
    }

    void guibing(List<Integer> left,int leftIndex,List<Integer> right,int rightIndex,ArrayList<Node> arrayList){
        int l = 0;
        int r = 0;
        while (l<left.size() || r<right.size()){
            if (l>=left.size()){
                arrayList.add(new Node(right.get(r),rightIndex));
                r++;
                continue;
            }
            if (r>=right.size()){
                arrayList.add(new Node(left.get(l),leftIndex));
                l++;
                continue;
            }
            if (left.get(l).equals(right.get(r))){
                arrayList.add(new Node(left.get(l),leftIndex,rightIndex));
                l++;
                r++;
                continue;
            }
            if (left.get(l).intValue()<right.get(r).intValue()){
                arrayList.add(new Node(left.get(l),leftIndex));
                l++;
                continue;
            }
            if (left.get(l).intValue()>right.get(r).intValue()){
                arrayList.add(new Node(right.get(r),rightIndex));
                r++;
                continue;
            }

        }
    }

    class Node{
        private int value;
        /**
         * 用于标记这个值属于哪几个index的数组，用于数值相等使用
         */
        private LinkedList<Integer> belongIndex;

        public Node() {
        }
        private Node linkedNewIndex(int index){
            this.belongIndex.add(index);
            return this;
        }
        public Node(int value,int...index){
            this.value = value;
            belongIndex = new LinkedList<>();
            for (int tmp : index){
                belongIndex.add(tmp);
            }
        }
        public Node(int value, LinkedList<Integer> belongIndex) {
            this.value = value;
            this.belongIndex = belongIndex;
        }
    }

    /**
     * :[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * @param args
     */
    public static void main(String[] args) {
//        List<List<Integer>> lists = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(4);l1.add(10);l1.add(15);l1.add(24);l1.add(26);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(0);l2.add(9);l2.add(12);l2.add(20);
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(5);l3.add(18);l3.add(22);l3.add(30);
//        lists.add(l1);lists.add(l2);lists.add(l3);
//
//        Q632 q632 = new Q632();
//        int[] ints = q632.smallestRange(lists);
//        System.out.println(ints);

        /**
         * [[1,3,5,7,9,10],[2,4,6,8,10]]
         */

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);l1.add(3);l1.add(5);l1.add(7);l1.add(9);l1.add(10);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);l2.add(4);l2.add(6);l2.add(8);l2.add(10);

        lists.add(l1);lists.add(l2);
        Q632 q632 = new Q632();
        int[] ints = q632.smallestRange(lists);
        System.out.println(ints);
    }

}
