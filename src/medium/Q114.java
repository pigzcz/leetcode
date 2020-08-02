package medium;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Q114 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public void flatten(TreeNode root) {
          if (root == null){
              return;
          }
        if (root.left != null){
            TreeNode tmp = root.right;

            root.right = root.left;
            root.left = null;
            flatten(root.right);
            while (root.right != null){
                root = root.right;
            }
            root.right = tmp;
        }
        flatten(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l1l1 = new TreeNode(3);
        TreeNode l1r1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(5);
        TreeNode r1r1 = new TreeNode(6);
        root.right = l1;
        l1.left = l1l1;
//        l1.right = l1r1;
//        root.right = r1;r1.right = r1r1;
        Q114 q114 = new Q114();
        q114.flatten(root);
        System.out.println(root);
    }
}
