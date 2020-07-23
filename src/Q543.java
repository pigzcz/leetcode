import java.util.HashMap;
import java.util.Map;

public class Q543 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
          TreeNode(int x) { val = x; }
  }
    int n =0;
    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return n-1;

    }
    public int deep(TreeNode node){
        if (node == null){
            return 0;
        }
        int l = deep(node.left);
        int r = deep(node.right);
        n = Math.max(l+r+1,n);
        return Math.max(l,r)+1;
    }


    public boolean canThreePartsEqualSum(int[] A) {
        int totals= 0;
        for (int i=0;i<A.length;i++){
            totals = totals+A[i];
        }
        int s1=0;
        for (int i=1;i<A.length;i++){
            s1 =s1+A[i-1];
            int sie=totals-s1;
            int si=0;
            for (int j=i+1;j<A.length;j++){
                si=si+A[j-1];
                int se=sie-si;
                if (s1==si&&s1==se){
                    return true;
                }
            }
        }
        return false;
    }

    public static String gcdOfStrings(String str1, String str2) {
        String index = null;
        if (str1.length()>str2.length()){
            index = str2;
        } else {
            index=str1;
        }
        for (int i=1;i<=index.length();i++){
            String c = index.substring(0,i);
            if (str1.replace(c,"").equals("")&&str2.replace(c,"").equals("")){
                return c;
            }
        }

        return "";
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : nums){
            Integer integer = map.get(i);
            if (integer == null){
                integer =0;
            }
            integer=integer+1;
            if (integer>nums.length/2){
                return i;
            }
            map.put(i,integer);

        }
        return 0;
    }




    public static void main(String[] args) {
        gcdOfStrings("ABCABC","ABC");
        int[] te=new int[]{10,9,2,5,3,7,101,18};


    }
}
