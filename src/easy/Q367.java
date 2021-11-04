package easy;

/**
 * @author:johnson.zhu
 * @Date: 2021/11/4 10:04 上午
 * @Description:
 **/
public class Q367 {
    public boolean isPerfectSquare(int num) {
        long i =1L;
        while (true){
            if ((long)num == i*i){
                return true;
            }
            if ((long)num > i*i){
                return false;
            }
            i++;
        }
    }
    /**
     * 二分法
     *
     */
    public boolean isPerfectSquare2(int num) {
        int left = 0;
        int right = num;
        while (left<=right){
            int mid = (right-left)/2 + left;
            long se =(long) mid * mid;
            if (se == num){
                return true;
            } else if (se < num){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q367 q367 = new Q367();
        boolean perfectSquare2 = q367.isPerfectSquare2(2147483647);
        System.out.println(perfectSquare2);
    }
}
