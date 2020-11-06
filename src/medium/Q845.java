package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/11/6 19:55
 * @Description:
 * 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 */
public class Q845 {

    private int count =0;
    public int longestMountain(int[] A) {
        longestMountain(A,0,A.length-1);
        return count;
    }

    public void longestMountain(int[]A, int start , int end){
        if(start >= end){
            return;
        }
        int index = findMax(A,start,end);

        int lc = leftC(A,start,index);
        int rc = rightC(A,end,index);
        int lrc = lc +rc + 1;
        if(lrc>count && lc !=0 && rc !=0){
            count = lrc;
        }
        if (lc ==0 || rc==0){
            lc =0;
            rc=0;
        }
        int lend = index -1;
        longestMountain(A,start,lend);
        int rstart = index + 1;
        longestMountain(A,rstart,end);

    }

    public int leftC(int[]A ,int start,int index){
        if(start == index){
            return 0;
        }
        int count = 0;
        for(int i=index-1;i>=start;i--){
            if(A[i]<A[i+1]){
                count++;
            } else{
                return count;
            }
        }
        return count;
    }
    public int rightC(int[]A,int end, int index){
        if(end == index){
            return 0;
        }
        int count=0;
        for(int i=index+1;i<=end;i++){
            if(A[i]<A[i-1]){
                count++;
            }else{
                return count;
            }
        }
        return count;

    }

    public int findMax(int[]A,int start ,int end){
        int max = -1;
        int maxIndex=-1;
        for(int i=start;i<=end;i++){
            if(A[i]>max){
                max = A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void main(String[] args) {
        Q845 q845 = new Q845();
        int[] a = new int[]{875,884,239,731,723,685};
        int i = q845.longestMountain(a);
        System.out.println(i);
    }
}