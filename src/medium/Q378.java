package medium;

/**
 *
 *
 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。



 示例：

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 返回 13。


 提示：
 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 */
public class Q378 {
    /**
     * 解法1 归并排序
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1){
            return matrix[0][k-1];
        }
        if (matrix.length==2){
            int[] c = merge(matrix[0],matrix[1]);
            return c[k-1];
        }
        int[] c = merge(matrix[0],matrix[1]);
        for (int i=2;i<matrix.length;i++){
            c = merge(c,matrix[i]);
        }
        return c[k-1];
    }

    int[] merge(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int i =0;
        int j =0;
        int k = 0;
        while (k != c.length){
            if (i != a.length && j!=b.length){
                if (a[i]<b[j]){
                    c[k] = a[i];
                    i++;
                } else {
                    c[k] = b[j];
                    j++;
                }
            } else {
                if (i<a.length){
                    c[k] = a[i];
                    i++;
                }
                if (j<b.length){
                    c[k] = b[j];
                    j++;
                }

            }

            k++;
        }
        return c;
    }

    //TODO 二分查找
}
