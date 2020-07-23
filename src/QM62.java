import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-03-30 11:20
 * @Description:
 */
public class QM62 {
    public class Node{
        int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public int lastRemaining(int n, int m) {
        if (n==1){
            return 0;
        }
        if (m==1){
            return  n-1;
        }
        List<Integer> data = new ArrayList<>();
        for (int i=0;i<n;i++){
            data.add(i);
        }
        int k=0;
        while (data.size()!=1){
            k=(k+m)%data.size()-1;
            if(k<0){
                k=data.size()-1;
            }
            data.remove(k);
        }
        return data.get(0);
    }

    public static void main(String[] args) {
        leecode.QM62 qm62 = new leecode.QM62();
        int i = qm62.lastRemaining(10, 17);
        System.out.println(i);
        String x="学java";
        int length1 = x.length();
        int length = x.getBytes().length;
        System.out.println(length);
    }
}
