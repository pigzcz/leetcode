package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/31 14:58
 * @Description:
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Q5 {
    public String longestPalindrome(String s) {
        if(s==null || s.length() ==0){
            return "";
        }
        int max = 1;
        String result = s;
        for (int i=0;i<s.length()-1;i++){
            String s1 = s1(s,i);
            String s2 = s2(s,i,i+1);
            if (s1.length()>max){
                max = s1.length();
                result = s1;
            }
            if (s2.length()>max){
                max = s2.length();
                result = s2;
            }
        }
        return result;
    }

    public String s1(String s , int i){
        int start = i;
        int end = i;
        while (start>=0 && end <s.length()){
            if (s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            } else {
                break;
            }
        }
        return s.substring(start+1,end);
    }
    public String s2(String s, int i ,int j){
        int start = i;
        int end =j;
        while (start>=0 && end <s.length()){
            if (s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            } else {
                break;
            }
        }
        return s.substring(start+1,end);
    }

    public static void main(String[] args) {
        String s = "a";
        Q5 q5 = new Q5();
        String s1 = q5.longestPalindrome(s);
        System.out.println(s1);
    }




}
