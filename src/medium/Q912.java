package medium;

public class Q912 {

    public int[] sortArray(int[] nums) {
        if (nums.length<2){
            return nums;
        }
        if (nums.length==2){
            if (nums[0]>nums[1]){
                int tmp = nums[0];
                nums[0]=nums[1];
                nums[1]=tmp;
            }
        }
        quickSort(nums,1,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int p,int q){
        if (p<=q){
            int i = partationSolution(nums, p, q);
            quickSort(nums,p,i-1);
            quickSort(nums,i+1,q);
        }


    }
    public int partationSolution(int[] nums,int p,int q){
        if (nums[p-1]>nums[q]){
            int tmp =nums[q];
            nums[q]=nums[p-1];
            nums[p-1]=tmp;
        }
        int x=nums[q];
        int i=p-1;
        for (int j=p;j<q;j++){
            if (nums[j]<=x){
                i++;
                int c=nums[i];
                nums[i]=nums[j];
                nums[j]=c;
            }
        }
        i=i+1;
        int e=nums[i];
        nums[i]=nums[q];
        nums[q]=e;
        return i;

    }

    public static void main(String[] args) {
        Q912 q912 = new Q912();
        int[] ce = new int[]{3,9,7,2,5,10,6,8};
        int[] ints = q912.sortArray(ce);
        System.out.println(ints);
    }
}
