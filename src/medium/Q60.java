package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/7 10:58
 * @Description:
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Q60 {
    private int state = 0;
    private String result;
    private int k;
    public String getPermutation(int n, int k) {
        this.k = k;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        try {
            doGetPermutation(n,set,sb);
        }catch (RuntimeException e){

        }

        return result;
    }
    private void doGetPermutation(int n, Set<Integer> set,StringBuilder sb){
        if (state == k){
            return;
        }
        if (set.size() == n){
            state++;
            if(state == k){
                result = sb.toString();
                throw new RuntimeException();
            }
        }
        for (int i=1;i<=n;i++){
            if (set.contains(i)){
                continue;
            }
            sb.append(i);
            set.add(i);
            doGetPermutation(n,set,sb);
            set.remove(i);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    /**
     * 拿n==4来举例子
     * 初始数组linkedlist{1,2,3,4]}
     * [  1,     2,     3,      4  ]
     * 3!=6;
     * ["1-6","7-12","13-18","19-24"]
     * 第一个数为1是第1到第6个，第一个数为2是第7到12个
     *  k=9,k/6，商为1，k%6,mod=3可以看出在落在第二个区间所以linkedlist.get(1)
     *  linkedlist变为[1,3,4]
     *  sb=2
     *  问题转为在剩下的三个数中取第3个全排列
     *  2!=2
     *  [1,   3,  4]
     *  [1-2,3-4,5-6]
     *  3/2 =1,3%2=1
     *  linkedlist.get(1)
     *  linkedlist变为[1,4]
     *  sb=23
     *  问题转为在剩下的数取第一个全排列
     *  [1,4]
     *  [1,2]
     *  sb=231,linkedlist变为[4]
     *  最后再剩下的最后一个数填到sb尾部
     *
     * @param n
     * @param k
     * @return
     */
    int[] jiecheng;
    public String getPermutation2(int n, int k) {
        jiecheng = null;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=1;i<=n;i++){
            linkedList.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int tmpn = n;
        while (--tmpn > 0){
            int jiecheng = jiecheng(n, tmpn);
            int mod = k % jiecheng;
            int sh = k/jiecheng;
            /**
             * 模为0代表第sh-1个区间第mod个数
             */
            if (mod==0){
                sh = sh-1;
                mod = jiecheng;
            }
            sb.append(linkedList.get(sh));
            linkedList.remove(sh);
            /**
             *
             */
            k = mod;
        }
        sb.append(linkedList.get(0));
        return sb.toString();
    }
    int jiecheng(int n,int k){
        if (null == jiecheng){
            jiecheng = new int[n];
            int res =1;
            for (int i =1;i<=n;i++){
                res = i*res;
                jiecheng[n-i]=res;
            }
        }

        return jiecheng[n-k];
    }

    public static void main(String[] args) {
        Q60 q60 = new Q60();
        String permutation = q60.getPermutation(9, 143456);
        System.out.println(permutation);


        String permutation2 = q60.getPermutation2(9, 143456);
        System.out.println(permutation2);

    }
}
