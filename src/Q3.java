import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-05-02 00:09
 * @Description:
 */
public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0){
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
        s.indexOf("s");

        Map<Character,Integer> data = new HashMap<>();
        char[] chars = s.toCharArray();
        data.put(chars[0],0);
        int now = 0;
        int max = 1;
        for (int i=1;i<chars.length;i++){
            char tmp = chars[i];
            if (!data.containsKey(tmp)){
                max = Math.max(i-now+1,max);
                data.put(tmp,i);
            } else {
                int o = (Integer)data.get(tmp);
                for (int j=now;j<=o;j++){
                    data.remove(chars[j]);
                }
                now=o+1;
                data.put(tmp,i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        leecode.Q3 q3 = new leecode.Q3();
        int abcabcbb = q3.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(abcabcbb);
    }
}
