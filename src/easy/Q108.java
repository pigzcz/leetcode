package easy;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/27 11:15
 * @Description:
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Q108 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length == 0){
            return null;
        }
        int n = nums.length;
        int mid = (n-1+0)/2;
        TreeNode node = new TreeNode(nums[mid]);
        addLeft(nums,0,mid-1,node);
        addRight(nums,mid+1,n-1,node);
        return node;
    }
    public void addLeft(int[]nums,int start, int end,TreeNode node){
        if (start > end){
            return ;
        }
        if (start == end){
            TreeNode left = new TreeNode(nums[start]);{
                node.left = left;
                return ;
            }
        }
        if (start<end){
            int mid = (start+end)/2;
            TreeNode left = new TreeNode(nums[mid]);
            node.left = left;
            addLeft(nums,start,mid-1,left);
            addRight(nums,mid+1,end,left);
        }
    }
    public void addRight(int[]nums,int start, int end,TreeNode node){
        if (start > end){
            return ;
        }
        if (start == end){
            TreeNode right = new TreeNode(nums[start]);{
                node.right = right;
                return ;
            }
        }
        if (start<end){
            int mid = (start+end)/2;
            TreeNode right = new TreeNode(nums[mid]);
            node.right = right;
            addLeft(nums,start,mid-1,right);
            addRight(nums,mid+1,end,right);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-10,-3,0,5,9};
        Q108 q108 = new Q108();
        TreeNode treeNode = q108.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

}
