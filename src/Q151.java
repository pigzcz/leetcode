import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-10 13:23
 * @Description:
 */
public class Q151 {
    public String reverseWords(String s) {
        List<String> re = new ArrayList<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            if (c!=' '){
                sb.append(c);
            }
            if (c==' '){
                if (sb.length()!=0){
                    re.add(sb.toString());
                }
                sb = new StringBuilder();

            }
        }
        if (sb.length()!=0){
            re.add(sb.toString());

        }
        StringBuilder res = new StringBuilder();
        for (int i=re.size()-1;i>=0;i--){
            res.append(re.get(i));
            if (i!=0){
                res.append(" ");
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        List<Object> objectsOfCaptain = new ArrayList<>();
        int theRemainderOfCaptainLife = 1*365*24*60*1000;
        System.out.println(theRemainderOfCaptainLife);
        while (theRemainderOfCaptainLife-->0){
            objectsOfCaptain.add(new Object());
        }
        System.out.println(objectsOfCaptain.size());
    }
}
