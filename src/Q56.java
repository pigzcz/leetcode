import java.util.Arrays;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length==0||intervals.length==1){
            return intervals;
        }
        int[] s = new int[1000000];
        int[] sameflag = new int[1000000];
        int sameMax=0;
        int max = 0;
        for (int[] tmp : intervals){

            int start = tmp[0];
            int end = tmp[1];
            if (start==end){
                sameflag[start]=1;
                sameMax=Math.max(sameMax,start);

            }
            s[start]=s[start]+1;
            s[end] = s[end]-1;

            max=Math.max(max,end);
        }
        s = Arrays.copyOf(s,max+1);

        int[][] re = new int[intervals.length][2];
        int [] k=null;

        int flag =0;
        int index=0;
        for (int i=0;i<s.length;i++){

            if (s[i]>0 && flag==0){
                k=new int[2];
                k[0]=i;

            }
            if (s[i]>0){
                flag = flag+s[i];
            }
            if (s[i]<0){
                flag=flag+s[i];
                if (flag==0){
                    k[1]=i;
                    re[index++]=k;
                }
            }

        }
        if (sameMax!=0){
            sameflag=Arrays.copyOf(sameflag,sameMax+1);

            for (int i=0;i<sameflag.length;i++){
                if (sameflag[i]==1){
                    
                }
            }
        }

        return Arrays.copyOf(re,index);
    }

    public static void main(String[] args) {
        Q56 q56 = new Q56();
        int[][] x = new int[][]{{5,5},{1,3},{3,5},{4,6},{1,1},{3,3},{5,6},{3,3},{2,4},{0,0}};
        int[][] merge = q56.merge(x);
        System.out.println(merge);

    }
}
