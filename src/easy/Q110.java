package easy;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/17 19:49
 * @Description:
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class Q110 {
     public class TreeNode {
       int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    boolean balance = true;
     int flag = 0;
    public boolean isBalanced(TreeNode root) {
         deep(root);
        return balance;
    }
    int deep(TreeNode tree){
         if (null == tree){
             return 0;
         }
         int left = deep(tree.left);
         int right = deep(tree.right);
         if (flag == 0){
             balance = Math.abs(left-right)<=1;
             if (!balance){
                 flag = 1;
             }
         }
         return Math.max(left,right)+1;
    }
}
