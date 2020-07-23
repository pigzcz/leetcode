/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-27 09:48
 * @Description:
 */
public class Q33 {
    public int search(int[] nums, int target) {
        boolean right = true;
        if (target>nums[0]){
            right = false;
        } else if (target == nums[0]){
            return 0;
        }
        return doSearch(nums,target,1,nums.length-1,right);

    }

    private int doSearch(int[] nums,int target ,int start,int end,boolean right){
        if (start>end){
            return -1;
        }
        if (start==end){
            if (nums[start]!= target){
                return -1;
            }
        }
        int mid = (start+end)/2;
        if (nums[mid]==target){
            return mid;
        }
        if (right){
            if (nums[mid]>nums[0]){
                return doSearch(nums,target,mid+1,end,right);
            }
            if (nums[mid]<nums[0]){
                if (target>nums[mid]){
                    return doSearch(nums,target,mid+1,end,right);
                }
                if (target<nums[mid]){
                    return doSearch(nums,target,start,mid-1,right);
                }
            }
        }else {
            if (nums[mid]>nums[0]){
                if (target>nums[mid]){
                    return doSearch(nums,target,mid+1,end,right);
                }
                if (target<nums[mid]){
                    return doSearch(nums,target,start,mid-1,right);
                }
            }
            if (nums[mid]<nums[0]){
                return doSearch(nums,target,start,mid-1,right);
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Q33 q33 = new Q33();
        int[] x = new int[]{4,5,6,7,0,1,2};
        int search = q33.search(x, 0);
        System.out.println(search);
    }
}
