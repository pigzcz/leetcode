package hard;

/**
 * @author:johnson.zhu
 * @Date: 2021/5/15 11:11 上午
 * @Description:
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Q124 {
    /*
     c测试
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return max;
    }
    public int doMaxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        /**
         * 为什么要和0比较，是因为如果左子树最大值为负数，那么  不连通，因为任何数+负数都会变小
         * 所以置位0，右子树同理
         */
        int left = Math.max(doMaxPathSum(root.left),0);
        int right = Math.max(doMaxPathSum(root.right),0);
        max = Math.max(max,left+right+root.val);
        /**
         * 为何要max(left,right)是因为根节点只能连到左或右其一才能保证节点不重复通过
         */
        return Math.max(left,right)+root.val;

    }
}
