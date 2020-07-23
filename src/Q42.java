public class Q42 {
    public int trap(int[] height) {

        int result = 0;
        int lasthighRigthIndex = findHighIndex(height, 0, height.length);

        int lasthighLeftIndex = lasthighRigthIndex;

        int highRightIndex = lasthighRigthIndex;
        int highLeftIndex = lasthighLeftIndex;
        while ((highLeftIndex=findHighIndex(height,0,lasthighLeftIndex))!=-1){
            int high = height[highLeftIndex];
            for (int i=highLeftIndex+1;i<lasthighLeftIndex;i++){
                result=result+high-height[i];
            }
            lasthighLeftIndex=highLeftIndex;

        }
        while ((highRightIndex=findHighIndex(height,lasthighRigthIndex+1,height.length))!=-1){
            int high=height[highRightIndex];
            for (int i=lasthighRigthIndex+1;i<highRightIndex;i++){
                result=result+high-height[i];
            }
            lasthighRigthIndex=highRightIndex;
        }

    return result;

    }
    int findHighIndex(int[] height,int start,int end){
        if (start>height.length-1){
            return -1;
        }
        int highIndex =-1;
        int max = 0;
        for (int i=start;i<end;i++){
            if (height[i]>max){
                max=height[i];
                highIndex=i;
            }
        }
        return highIndex;

    }

    public static void main(String[] args) {
        int[] a =new int[]{4,2,0,3,2,5};
        Q42 q42 = new Q42();
        int trap = q42.trap(a);
        System.out.println(trap);
    }
}
