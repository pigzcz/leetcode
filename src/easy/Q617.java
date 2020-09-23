package easy;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/23 16:47
 * @Description:
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class Q617 {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return doMerge(t1,t2);
    }
    public TreeNode doMerge(TreeNode t1, TreeNode t2){
        if (null == t1 && t2 == null){
            return null;
        } else if (t1 == null){
            TreeNode t = new TreeNode(t2.val);
            t.left = doMerge(null,t2.left);
            t.right = doMerge(null,t2.right);
            return t;
        } else if (t2 == null){
            TreeNode t = new TreeNode(t1.val);
            t.left = doMerge(t1.left,null);
            t.right = doMerge(t1.right,null);
            return t;
        } else {
            TreeNode t = new TreeNode(t1.val + t2.val);
            t.left = doMerge(t1.left,t2.left);
            t.right = doMerge(t1.right,t2.right);
            return t;
        }
    }
}
