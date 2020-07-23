import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-09 09:47
 * @Description:
 */
public class QM22 {

    public List<String> generateParenthesis(int n) {
        if (n==1){
            return Arrays.asList("()");
        }

        List<String> realres = new ArrayList<>();
        List<Data> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        Data data = new Data(builder,1,n-1);
        res.add(data);
        while (!res.isEmpty()){
            List<Data> next = new ArrayList<>();
            for (Data tmp : res){
                if (tmp.zhanCount>0){
                    StringBuilder s1 = new StringBuilder(tmp.now);
                    s1.append('(');
                    Data d1= new Data(s1,tmp.zhanCount+1,tmp.leastCout-1);
                    if (d1.leastCout==0){
                        realres.add(get(d1,2*n));
                    } else {
                        next.add(d1);
                    }
                    StringBuilder s2 = new StringBuilder(tmp.now);
                    s2.append(')');
                    Data d2 = new Data(s2,tmp.zhanCount-1,tmp.leastCout);
                    if (d2.leastCout==0){
                        realres.add(get(d2,2*n));
                    } else {
                        next.add(d2);
                    }

                } else {
                    StringBuilder s1 = new StringBuilder(tmp.now);
                    s1.append('(');
                    Data d1 = new Data(s1,tmp.zhanCount+1,tmp.leastCout-1);
                    if (d1.leastCout==0){
                        realres.add(get(d1,2*n));
                    } else {
                        next.add(d1);
                    }
                }
            }
            res = next;
        }

        return realres;

    }
    private String get(Data node,int len){
        StringBuilder now = node.now;
        if (now.length()<len){
            int n = len-now.length();
            while (n-->0){
                now.append(')');
            }
        }
        return now.toString();
    }

    class Data{
        public StringBuilder now;
        public int zhanCount;
        public int leastCout;

        public Data(StringBuilder now, int zhanCount, int leastCout) {
            this.now = now;
            this.zhanCount = zhanCount;
            this.leastCout = leastCout;
        }
    }

    public static void main(String[] args) {
        QM22 qm22 = new QM22();
        List<String> strings = qm22.generateParenthesis(3);
        System.out.println(strings);
    }

}
