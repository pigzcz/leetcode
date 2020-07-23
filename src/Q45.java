/**
 * @Auther: johnson.zhu
 * @Date: 2020-05-04 09:07
 * @Description:
 */
public class Q45 {
    public int jump(int[] nums) {
        int ci = 0;
        int left=0,right=0;
        int yuan = 0;
        while (yuan<nums.length-1){

            ci++;
            for (int i=left;i<=right;i++){
                yuan = Math.max(nums[i]+i,yuan);
                if (yuan>=nums.length-1){
                    break;
                }
            }
            right=yuan;
            left = ci;
        }
        return ci;
    }

    public int jump1(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (maxPosition>=(length-1)){
                steps++;
                break;
            }
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        leecode.Q45 q45 = new leecode.Q45();
        int[] x= new int[]{2,3,1,1,4};
        int jump = q45.jump1(x);
        System.out.println(jump);

    }
}
