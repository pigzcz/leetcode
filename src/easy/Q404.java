package easy;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Q404 {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        doSum(root);
        return sum;
    }
    public void doSum(TreeNode node){
        if (null == node){
            return;
        }
        if (node.left != null && node.left.left==null && node.left.right ==null){
            sum = sum+node.left.val;
        }
        doSum(node.left);
        doSum(node.right);

    }
}
