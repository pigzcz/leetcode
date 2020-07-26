package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 410. 分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class Q410 {
    private List<int[]> group = new ArrayList<>();


    public int splitArray(int[] nums, int m) {

        int length = nums.length;
        int s[][] = new int[length][length];
        if (m == 1){
            return getS(0,length-1,nums,s);
        }



        int i = splitOne(nums, 0, length - 1, s, null);
        if (m==2){
            return i;
        }

        int min = Integer.MAX_VALUE;
        int tmpM = m-1;
        while (tmpM--!=0){
            List<int[]> tmpGroup = group;
            group = new ArrayList<>();
            for (int[] currentGroup : tmpGroup){
                int leftMax = getLeftMax(nums, currentGroup, s);
                int rightMax = splitOne(nums, getStart(currentGroup), length - 1, s, currentGroup);
                int tmpMax = Math.max(leftMax,rightMax);
                min = Math.min(tmpMax,min);
            }

        }


        return min;

    }

    public int getStart(int[] currentGroup){
        int start = 0;
        for (int i =0;i<currentGroup.length;i++){
            if (currentGroup[i]==1){
                start = i;
            }
        }
        return start+1;
    }

    public int getLeftMax(int[] nums,int[] currentGroup, int[][] s){
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i=0;i<currentGroup.length;i++){
            if (currentGroup[i] == 1){
                int tmp = getS(start, end, nums, s);
                max = Math.max(tmp,max);

                end++;
                start = end;
                if (i == currentGroup.length-1){
                    tmp = getS(start,end,nums,s);
                    max = Math.max(tmp,max);
                }
            }
            if (currentGroup[i]==0){
                end++;
                if (i == currentGroup.length-1){
                    int tmp = getS(start,end,nums,s);
                    max = Math.max(tmp,max);
                }
            }
        }
        return max;
    }

    public int splitOne(int[] nums,int start, int end, int[][] s,int[] currentGroup){
        if (start == end){
            return getS(start,end,nums,s);
        }
        int min = Integer.MAX_VALUE;

        for (int i = start;i<end;i++){
            if (currentGroup != null){
                int[] tmp = currentGroup.clone();
                tmp[i] = 1;
                group.add(tmp);
            } else {
                int[] tmp = new int[nums.length-1];
                tmp[i] = 1;
                group.add(tmp);
            }

            int sLeft = getS(start,i,nums,s);
            int sRight = getS(i+1,end,nums,s);
            int tmp = Math.max(sLeft,sRight);
            min = Math.min(min,tmp);
        }
        return min;
    }

    public int getS(int start, int end, int[] nums,int[][]s){
        if (s[start][end] != 0){
            return s[start][end];
        }
        int sum =0;
        for (int i=start;i<=end;i++){
            sum = sum + nums[i];
        }
        s[start][end] = sum;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,200};
        Q410 q410 = new Q410();
//        int[][] s = new int[nums.length][nums.length];
//        int[] group = new int[nums.length-1-0];
//        int i = q410.splitOne(nums, 0, nums.length - 1, s,group);
        int i1 = q410.splitArray5(nums, 2);

        System.out.println(i1);
    }

    public int splitArray2(int[] nums, int m) {
        int length = nums.length;

        int groupO[] = new int[length-1];
        for (int i=0;i<groupO.length;i++){
            groupO[i] = 1;
        }
        group.add(groupO);
        int s[][] = new int[length][length];
        if (m == nums.length){
            return getLeftMax(nums,groupO,s);
        }

        int k = length-m;
        int reslut = 0;
        while (k--!=0) {
            int min = Integer.MAX_VALUE;
            List<int[]> groupClone = group;
            group = new ArrayList<>();
            for (int[] tmpGroup : groupClone) {
                for (int i = 0; i < tmpGroup.length; i++) {
                    if (tmpGroup[i] == 1) {
                        int[] tmpClone = tmpGroup.clone();
                        tmpClone[i] = 0;
                        group.add(tmpClone);
                        int leftMax = getLeftMax(nums, tmpClone, s);
                        min = Math.min(leftMax, min);
                    }
                }
                reslut = min;
            }
        }


        return reslut;
    }

    /**
     * {7,7,2,10,8}  动态规划法 f[i][j] 表示前i个数分割j段
     * 那么f[i][j] = max(f[1~(i-1)][j-1],s[2~i]) 中的最小值
     * @param nums
     * @param m
     * @return
     */
    public int splitArray3(int[] nums, int m) {
        int length = nums.length;
        int[][] f = new int[length+1][m+1];
        int[][] s = new int[length][length];
        for (int i=0;i<f.length;i++){
            for (int j =0;j<f[0].length;j++){
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        int sum = 0;
        for (int i=1;i<=length;i++){
            sum = sum+nums[i-1];
            f[i][1] = sum;
        }
        for (int i =2;i<=length;i++){
            for (int j = 2;j<= Math.min(i,m);j++){
                for (int k = 1;k<i;k++){
                    f[i][j] = Math.min(f[i][j],Math.max(f[k][j-1],getS(k,i-1,nums,s)));
                }
            }
        }

        return f[length][m];

    }

    /**
     * 7,7,2,10,8
     * @param nums
     * @param m
     * @return
     */
    public int splitArray4(int[] nums, int m) {
        int sum=0;
        int arrayMax = 0;
        for (int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            arrayMax = Math.max(arrayMax,nums[i]);
        }
        /**
         * 从sum到数组中的最大值，得到第一个分割数组>m的value 加一返回
         * 会超时，采用2分法
         */
        for (int value = sum;value>=arrayMax;value--){
            boolean check = check(nums, value, m);
            if (!check){
                return value+1;
            }
        }

        return arrayMax;

    }

    /**
     * 判断给定一个数，能否分割成小于等于m个数组
     * @param nums
     * @param value
     * @param m
     * @return
     */
    public boolean check(int nums[], int value, int m){
        int sum=0;
        int count =1;
        for (int i=0;i<nums.length;i++){
            if (sum+nums[i]>value){
                count++;
                sum = nums[i];
            } else {
                sum = sum+nums[i];
            }
        }
        return count<=m;
    }

    public int splitArray5(int[] nums, int m) {
        int sum=0;
        int arrayMax = 0;
        for (int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            arrayMax = Math.max(arrayMax,nums[i]);
        }
        /**
         * 用二分法找到 sum到arrayMax 第一个分割数组>m的value并返回(最大的最小值)
         */
        int left = arrayMax;int right = sum;
        while (left<right){
            int mid = (right-left)/2+left;
            if (check(nums,mid,m)){
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;

    }

}
