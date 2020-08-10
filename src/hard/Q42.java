package hard;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
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
