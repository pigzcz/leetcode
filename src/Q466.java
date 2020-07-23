import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-20 14:49
 * @Description:
 */
public class Q466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        Map<String, Object> aa1 = getAA(s1);
        int c =(Integer) aa1.get("count");
        s1 =(String) aa1.get("string");

        Map<String, Object> aa = getAA(s2);
        int count = (Integer)aa.get("count");
        s2 = (String)aa.get("string");
        boolean can = can(s1,s2);
        if (!can){
            StringBuilder sb = new StringBuilder(s1);
            for (int i=2;i<=s2.length();i++){
                sb.append(sb);
                String s = sb.toString();
                if (can(s,s2)){
                    float re = (float)n1/(float) count/(float) i/(float) n2*(float) c;
                    return (int)re;
                }
            }

        } else {
            StringBuilder sb = new StringBuilder(s2+s2);
            int n = 2;
            while (can(s1,sb.toString())){
                sb=sb.append(s2);
                n++;
            }
            float re= (float)n1/(float) count*(float) (n-1)/(float) n2*(float) c;
            return (int)re;
        }
        return 0;
    }

    public boolean can(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();


        int i2=0;
        int i1=0;
        int start=i1;
        int index=0;
        while ((index=find(chars1,chars2[i2],start))!=-1){
            start = index+1;
            if (i2==chars2.length-1){
                return true;
            }
            i2=i2+1;

        }


        return false;


    }
    public int find(char[] chars,char x,int index){
        for (int i=index;i<chars.length;i++){
            if (chars[i]==x){
                return i;
            }
        }
        return -1;
    }

    public Map<String,Object> getAA(String x){
        char[] chars = x.toCharArray();

        char f = chars[0];
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for (int i=1;i<chars.length;i++){
            if (chars[i]==f){
                if (x.replace(sb.toString(),"").equals("")){
                    break;
                }

            }
            sb.append(chars[i]);
        }

        String re = sb.toString();
        String s = x.replaceFirst(re, "");
        int coutn =1;
        while (!s.equals("")){
            s=s.replaceFirst(re,"");
            coutn++;
        }
        Map<String,Object> res = new HashMap<>();
        res.put("string",re);
        res.put("count",coutn);
        return res;
    }

    public int getMaxRepetition2s(String s1, int n1, String s2, int n2) {
        if(n1==0) return 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = s1.length();
        int l2 = s2.length();
        int couts1=0;//经历多少s1
        int couts2=0;//经历多少s2
        int p=0;//当前在s2的位置
        Map<Integer,int[]> mp = new HashMap<>();//记录每一次s1扫描结束后当前的状态，寻找循环
        while(couts1<n1){
            for(int i=0;i<l1;i++){
                if(c1[i]==c2[p]){//往前
                    p++;
                    if(p==l2){//s2扫描结束从头开始循环
                        p=0;
                        couts2++;
                    }
                }
            }
            couts1++;
            if(!mp.containsKey(p)){
                mp.put(p,new int[]{couts1,couts2});//记录当前状态

            }
            else{//出现了循环 这次结束后p的位置和以前某一次一样，就是循环
                int[] last =mp.get(p);
                int circle1= couts1-last[0];
                int circle2= couts2-last[1];
                couts2 += circle2*((n1-couts1)/circle1);
                couts1 = couts1+((n1-couts1)/circle1)*circle1;//更新新他们
            }
        }
        return couts2/n2;
    }
    public static void main(String[] args) {
        leecode.Q466 q466 = new leecode.Q466();
        String s1 = "bacaba";
        String s2 = "abacab";
        boolean can = q466.can(s1, s2);
        System.out.println(can);
    }
}
