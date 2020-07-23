import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-03 12:45
 * @Description:
 */
public class Q8 {
    private boolean isFu=false;
    LinkedList<Integer> data = new LinkedList<>();
    private boolean isFUhao = false;
    static Map<Character,Integer> shuziSet = new HashMap();
    private boolean has0=false;


    public int myAtoi(String str) {
        for (int i=0;i<10;i++){
            shuziSet.put(String.valueOf(i).toCharArray()[0],i);
        }
        char[] chars = str.toCharArray();
        for (char tmp : chars){
            if (tmp==' '&&data.size()==0){
                if (has0){
                    return 0;
                }
                if (isFUhao){
                    return 0;
                }
                continue;
            }
            if (!shuziSet.containsKey(tmp)&&(tmp!='-'&&tmp!='+')&&data.size()==0){
                return 0;
            }
            if ((tmp=='-'||tmp=='+')&&data.size()==0){
                if (isFUhao){
                    return 0;
                }
                if (has0){
                    return 0;
                }
                isFUhao=true;
                if (tmp=='-'){
                    isFu=true;
                }
                continue;
            }
            if (tmp=='0'&&data.size()==0){
                has0=true;
                continue;
            }
            if (!shuziSet.containsKey(tmp)&&data.size()!=0){
                break;
            }

            if (shuziSet.containsKey(tmp)){
                data.addFirst(shuziSet.get(tmp));
            }
        }
        int i=0;
        int result=0;
        if (data.size()>10){
            return isFu?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        while (!data.isEmpty()){
            Integer integer = data.pollFirst();
            if (i==9){
                if (integer>2){
                    return isFu?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
            }
            result=result+integer*(int)Math.pow(10,i);
            if (result<0){
                return isFu?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            i++;
        }
        return result*(isFu?-1:1);
    }

    public static void main(String[] args) {
        String a="   -42";
        Q8 q8 = new Q8();
        int i = q8.myAtoi(a);
        System.out.println(i);
        int k = Integer.MIN_VALUE;
        System.out.println(k);

    }
}
