package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/7/28 14:57
 * @Description:
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class Q104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        List<TreeNode> childList = new LinkedList<>();
        childList.add(root);
        int deep = 0;
        while (childList.size() != 0){
            deep++;
            List<TreeNode> tmpChild = new LinkedList<>();
            for (TreeNode treeNode : childList){
                if (treeNode.left != null){
                    tmpChild.add(treeNode.left);
                }
                if (treeNode.right != null){
                    tmpChild.add(treeNode.right);
                }
            }
            childList = tmpChild;
        }
        return deep;
    }

}
