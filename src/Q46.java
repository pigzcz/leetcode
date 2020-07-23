import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-25 08:13
 * @Description:
 */
public class Q46 {

    private int length=0;
    public List<List<Integer>> permute(int[] nums) {
        if (null == nums||nums.length==0){
            return null;
        }
        List<List<Integer>> re = new ArrayList<>();
        LinkedList<Integer> init = new LinkedList<>();
        init.add(nums[0]);
        re.add(init);
        for (int i=1 ;i<nums.length;i++){

            List<List<Integer>> t = new ArrayList<>();
            for (List<Integer> tmp :  re){
                for (int j=0;j<=tmp.size();j++){
                    LinkedList tmp1 = (LinkedList) tmp;
                    LinkedList clone = (LinkedList)tmp1.clone();
                    clone.add(j,nums[i]);
                    t.add(clone);
                }

            }
            re = t;
        }
        return re;
    }


    public static void main(String[] args) {
        int[] x= new int[]{1,2,3};
        Q46 q46 = new Q46();
        List<List<Integer>> permute = q46.permute(x);
        System.out.println(permute);
    }
}
