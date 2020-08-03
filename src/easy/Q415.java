package easy;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/3 13:51
 * @Description:
 *
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Q415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int sbI = 0;
        while (l1>0 || l2>0){
            sbI = add(sb, num1, num2, l1 - 1, l2 - 1, sbI);
            l1--;
            l2--;
        }
        return sb.reverse().toString();
    }

    int add(StringBuilder stringBuilder,String num1,String num2,int i1,int i2, int sbI){
        int sum = 0;

        if (i1>=0){
            sum = sum + getNum(num1.charAt(i1));
        }
        if (i2>=0){
            sum = sum + getNum(num2.charAt(i2));
        }
        if (stringBuilder.length()>sbI){
            sum = sum + getNum(stringBuilder.charAt(sbI));
            if (sum>=10){
                stringBuilder.setCharAt(sbI,getChar(sum-10));
                stringBuilder.append(1);
            } else {
                stringBuilder.setCharAt(sbI,getChar(sum));
            }
        } else {
            if (sum>=10){
                stringBuilder.append(sum-10);
                stringBuilder.append(1);
            } else {
                stringBuilder.append(sum);
            }
        }
        return sbI+1;
    }

    char getChar(int num){
        if (num == 0){
            return '0';
        }
        if (num == 1){
            return '1';
        }
        if (num == 2){
            return '2';
        }
        if (num == 3){
            return '3';
        }
        if (num == 4){
            return '4';
        }
        if (num == 5){
            return '5';
        }
        if (num == 6){
            return '6';
        }
        if (num == 7){
            return '7';
        }
        if (num == 8){
            return '8';
        }
        if (num == 9){
            return '9';
        }
        return '1';
    }

    int getNum(char num){
        if (num == '0'){
            return 0;
        }
        if (num == '1'){
            return 1;
        }
        if (num == '2'){
            return 2;
        }
        if (num == '3'){
            return 3;
        }
        if (num == '4'){
            return 4;
        }
        if (num == '5'){
            return 5;
        }
        if (num == '6'){
            return 6;
        }
        if (num == '7'){
            return 7;
        }
        if (num == '8'){
            return 8;
        }
        if (num == '9'){
            return 9;
        }
        return 0;
    }


    public static void main(String[] args) {
        Q415 q415 = new Q415();
        String s = q415.addStrings("055", "5");
        System.out.println(s);
    }
}
