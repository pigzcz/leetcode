package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 *
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Q93 {
    public List<String> restoreIpAddresses(String s) {

        int length = s.length();
        List<String> list = new LinkedList<>();
        if (s.length()>12){
            return list;
        }
        for(int i=3;i<length;i++){
            for (int j=2;j<i;j++){
                for (int k = 1;k<j;k++){
                    String s1 = s.substring(0,k);
                    String s2 = s.substring(k,j);
                    String s3 = s.substring(j,i);
                    String s4 = s.substring(i,length);
                    if (illegal(s1)&&illegal(s2)&&illegal(s3)&&illegal(s4)){
                        String res = s1+"."+s2+"."+s3+"."+s4;
                        list.add(res);
                    }

                }
            }
        }
        return list;
    }

    public boolean illegal(String s){
        if(s.length()>3){
            return false;
        }
        if (s.startsWith("0")&&!s.equals("0")){
            return false;
        }
        if (s.startsWith("00")|| s.equals("000")){
            return false;
        }
        if (Integer.valueOf(s)<=255){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        Q93 q93 = new Q93();
        List<String> strings = q93.restoreIpAddresses(s);
        System.out.println(strings);
    }
}
