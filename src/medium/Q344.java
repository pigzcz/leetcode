package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/10/10 14:53
 * @Description:
 */
public class Q344 {
    public void reverseString(char[] s) {
        int i1 = 0;
        int i2 = s.length-1;
        while (i1<i2){
            char tmp = s[i1];
            s[i1]=s[i2];
            s[i2]=tmp;
            i1++;i2--;
        }
    }
}
