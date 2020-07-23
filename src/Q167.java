import java.util.HashMap;
import java.util.Map;

public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <=1 || numbers[0]>target){
            return new int[2];
        }

        Map<Integer,Integer> map = new HashMap<>(numbers.length);

        for (int i=0;i<numbers.length;i++){

                map.put(numbers[i],i);

        }
        for (int i=0;i<=numbers.length;i++){
            if (map.containsKey(target - numbers[i])){
                return new int[]{i+1,map.get(target-numbers[i])+1};
            }
        }
        return new int[2];
    }
    public int[] twoSum1(int[] numbers, int target) {
        if (numbers.length <=1 || numbers[0]>target){
            return new int[2];
        }

        int i = 0;
        int j = numbers.length-1;
        while (i!=j){
            int tmp = numbers[i]+numbers[j];
            if (tmp == target){
                return new int[]{i+1,j+1};
            }
            if (tmp>target){
                j=j-1;
            }
            if (tmp<target){
                i=i+1;
            }
        }


        return new int[2];
    }

    public static void main(String[] args) {
        Q167 q167 = new Q167();
        int[] ints = q167.twoSum(new int[]{-1, 0}, -1);

        System.out.println(ints);
    }
}
