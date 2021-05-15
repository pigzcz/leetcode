package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author:johnson.zhu
 * @Date: 2021/5/15 2:50 下午
 * @Description:
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 **/
public class Q111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        if (null == root){
            return 0;
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int deep = 1;
        while (!list.isEmpty()){
            List<TreeNode> tmpList = new LinkedList<>();
            for (TreeNode node : list){
                if (node.left == null && node.right == null){
                    return deep;
                }
                if (null != node.left){
                    tmpList.add(node.left);
                }
                if (null != node.right){
                    tmpList.add(node.right);
                }
            }
            list = tmpList;
            deep ++;
        }
        return deep;
    }
}
