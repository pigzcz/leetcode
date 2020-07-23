public class QM11 {
    public int maxArea(int[] height) {

        int max = 0;
        int i=0;
        int j = height.length-1;
        while (i!=j){
            int left = height[i];
            int right = height[j];
            int key =Math.min(left,right);
            int n = j-i;
            int tmpMax = n*key;
            max = Math.max(max,tmpMax);
            if (left>right){
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

    private int findRightFirstIndex(int[]height,int left,int key){
        for (int i=height.length-1;i>left;i--){
            if (height[i]>=key){
                return i-left;
            }
        }
        return 0;
    }

    private int findLeftFirstIndex(int[]height,int right,int key){
        for (int i=0;i<right;i++){
            if (height[i]>=key){
                return right-i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] inxe = new int[]{1,8,6,2,5,4,8,3,7};
        QM11 qm11 = new QM11();
        qm11.maxArea(inxe);
    }
}
