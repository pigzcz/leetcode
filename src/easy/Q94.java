package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Q94 {
    /**
     * 非递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            while (null != node) {
                stack.add(node);
                node = node.left;
            }
            TreeNode treeNode = stack.removeLast();
            res.add(treeNode.val);
            node = treeNode.right;
        }
        return res;
    }
    public class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
