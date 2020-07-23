public class Q55 {
    public boolean canJump(int[] nums) {
        int[] flag= new int[nums.length];
        flag[0]=1;
        for (int i=1;i<flag.length;i++){
            int n = nums[nums.length-1-i];
            if (n==0){
                flag[i]=0;
                continue;
            }
            for (int j=1;j<=n;j++){
                if (flag[i-j]==1){
                    flag[i]=1;
                    break;
                }
            }

        }
        return flag[nums.length-1]==1;
    }
    public static void main(String[] args) {
        int[] x =new int[]{2,0,0};
        Q55 q55 = new Q55();
        boolean b = q55.canJump(x);


        System.out.println(b);
    }
}
