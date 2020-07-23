/**
 * @Auther: johnson.zhu
 * @Date: 2020-03-27 14:58
 * @Description:
 */
public class Q10_01 {
    public static   void merge(int[] A, int m, int[] B, int n) {
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
        if (m==0){
            for (int i=0;i<n;i++){
                A[i]=B[i];
            }
        }

    }

    public static void main(String[] args) {
        int[] A= new int[]{2,0};
        int[] b=new int[]{1};
        merge(A,1,b,1);
    }

}
