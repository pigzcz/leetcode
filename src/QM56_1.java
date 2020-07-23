public class QM56_1 {

    public int[] singleNumbers(int[] nums) {
        int k=0;
        for (int i=0;i<nums.length;i++){
            k = k^nums[i];
        }
        int i=0;
        while ((k>>i|1)!=k>>i){
            i++;
        }
        int a = 0;
        int b = 0;
        for (int j=0;j<nums.length;j++){
            if (((nums[j]>>i)&1)==0){
                a=a^nums[j];
            } else {
                b= b^nums[j];
            }
        }
        return new int[]{a,b};

    }

    public static void main(String[] args) {
        System.out.println(25>>0|1);
        System.out.println(25>>0);
        System.out.println(4&1);

        int[] x =new int[]{4,4,6,8,1,1};
        QM56_1 qm56_1 = new QM56_1();
        int[] ints = qm56_1.singleNumbers(x);
        System.out.println(ints);
    }
}
