package easy;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/8 17:07
 * @Description:
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class QM10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        if (n==0){
            return;
        }
        if (m==0){
            for (int i=0;i<n;i++){
                A[i]=B[i];
            }
            return;
        }
        int index = m+n-1;
        while (n!=0&&m!=0){
            if (B[n-1]>=A[m-1]){
                A[index]=B[n-1];
                n--;
                index--;
                continue;
            }
            if (B[n-1]<A[m-1]){
                A[index]=A[m-1];
                m--;
                index--;
                continue;
            }
        }
        if (m==0 && n!=0){
            for (int i=0;i<n;i++){
                A[i]=B[i];
            }
        }

    }
}
