/**
 * @Auther: johnson.zhu
 * @Date: 2019-08-24 16:04
 * @Description:
 */
public class Question58 {
    //给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
    //
    //如果不存在最后一个单词，请返回 0 。
    //
    //说明：一个单词是指由字母组成，但不包含任何空格的字符串。
    //
    //示例:
    //
    //输入: "Hello World"
    //输出: 5


    public int lengthOfLastWord(String s) {
        s = s.trim();
        s = " "+s;
        int k = 0;
        for (int i = s.length()-1;i>=0;i--){
            if (s.charAt(i)!=' '){
                k++;
            } else {
                return k;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "Hello world";
        leecode.Question58 question58 = new leecode.Question58();
        int i = question58.lengthOfLastWord(s);
        System.out.println(i);
    }
}
