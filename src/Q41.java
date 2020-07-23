import java.util.HashSet;
import java.util.Set;

public class Q41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){
                set.add(nums[i]);
            }
        }
        int i=1;
        while (set.contains(i)){
            i++;
        }
        return i;
    }

    public int firstMissingPositive2(int[] nums) {
        int length = nums.length;
        boolean contain = false;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1){
                contain = true;
                break;
            }
        }
        if (!contain){
            return 1;
        }
        if (length == 1){
            return 2;
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]<1 || nums[i]>length){
                nums[i]=1;
            }
        }
        for (int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if (index == length){
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (int i=1;i<length;i++){
            if (nums[i]>0){
                return i;
            }
        }
        if (nums[0]>0){
            return length;
        }
        return length+1;
    }
}
