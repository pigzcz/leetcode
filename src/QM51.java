/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-24 17:13
 * @Description:
 */
public class QM51 {
    private int count =0;
    public int reversePairs(int[] nums) {
        int[] handle = handle(nums, 0, nums.length - 1);
        return count;
    }

    public int[] handle(int[]nums,int start,int end){

        if (start == end){
            return new int[]{nums[start]};
        }
        int mid =(start+end)/2;
        int[] left = handle(nums,start,mid);
        int[] right = handle(nums,mid+1,end);
        int l=0;
        int r = 0;
        int index=0;
        int ll = left.length;
        int rl = right.length;
        int[] re = new int[ll+rl];
        while (l!=ll||r!=rl){
            if (l==ll){
                re[index] = right[r];
                r++;
                index++;
                continue;
            }
            if (r == rl){
                re[index] = left[l];
                l++;
                index++;
                continue;
            }
            if (left[l]>right[r]){
                count = count + rl-r;
                re[index]=left[l];
                l++;
                index++;
            } else {
                re[index]=right[r];
                r++;
                index++;

            }
        }
        return re;
    }

    public static void main(String[] args) {
        QM51 qm51 = new QM51();
        int[] x = new int[]{7,5,6,4};
        int i = qm51.reversePairs(x);
        System.out.println(i);

    }
}
