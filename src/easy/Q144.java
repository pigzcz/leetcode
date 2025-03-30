package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 144. 二叉树的前序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 *
 * 输出：[1,2,3]
 *
 * 解释：
 *
 *
 *
 * 示例 2：
 *
 * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
 *
 * 输出：[1,2,4,5,6,7,3,8,9]
 *
 * 解释：
 *
 *
 *
 * 示例 3：
 *
 * 输入：root = []
 *
 * 输出：[]
 *
 * 示例 4：
 *
 * 输入：root = [1]
 *
 * 输出：[1]
 *
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Q144 {
    /**
     * 非递归方法解题
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (null != node) {
                res.add(node.val);
                stack.add(node);
                node = node.left;
            }
            node = stack.removeLast().right;
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
