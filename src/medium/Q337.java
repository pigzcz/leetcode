package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/5 10:05
 * @Description:
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class Q337 {
    public static class TreeNode {
      int val;
      TreeNode left;TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public int rob(TreeNode root) {
        int in = in(root);
        int i = notIn(root);
        return Math.max(in,i);
    }
    int in(TreeNode root){
        if (root == null){
            return 0;
        }
        return root.val + notIn(root.left) + notIn(root.right);
    }
    int notIn(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(notIn(root.left),in(root.left))+Math.max(notIn(root.right),in(root.right));
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        treeNode.left=l1;
        TreeNode r1 = new TreeNode(5);
        treeNode.right = r1;
        TreeNode l1l1 = new TreeNode(1);
        l1.left = l1l1;
        TreeNode l1r1 = new TreeNode(4);
        l1.right = l1r1;
        TreeNode r1r1 = new TreeNode(1);
        r1.right = r1r1;
        Q337 q337 = new Q337();
        int e= q337.rob(treeNode);
        System.out.println(e);
    }
}
