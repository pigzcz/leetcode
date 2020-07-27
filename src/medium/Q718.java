package medium;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *  
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 */
public class Q718 {

    /**
     * B数组滑过A数组
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int startA = 0;
        int startB = B.length-1;
        while (startA!=A.length-1 || startB !=0){
            int i = startA;
            int j = startB;
            int tmpMax = 0;
            while (i!= A.length && j!= B.length){
                if (A[i] == B[j]){
                    tmpMax++;
                    if (i == A.length-1 || j == B.length-1){
                        if (tmpMax>max){
                            max = tmpMax;
                        }
                    }
                }else {
                    if (tmpMax>max){
                        max = tmpMax;
                    }
                    tmpMax = 0;
                }
                i++;
                j++;
            }

            if (startB!=0){
                startB--;
            } else {
                startA++;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Q718 q718 = new Q718();
        int[] a = new int[]{0,0,0,0,0};
        int[] b = new int[]{0,0,0,0,0};
        System.out.println(q718.findLength(a,b));
    }
}
