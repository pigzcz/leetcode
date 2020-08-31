package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/28 18:51
 * @Description:
 */
public class Q31 {
    /**
     * 1234785
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
    }
    private void sort(int[] nums,int start,int end){
        int min = nums[start];
        int k = start+1;
        while (k<end){
            if (nums[k]<min){
                min = nums[k];
            }
            k++;
        }

    }
}
