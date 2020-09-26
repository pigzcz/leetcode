package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Q113 {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> tmp = new LinkedList<>();
        doPathSum(root,sum,tmp,0);
        return res;
    }
    public void doPathSum(TreeNode root, int sum, LinkedList<Integer> tmp,int current){

        if (root != null){
            tmp.add(root.val);
            current = current + root.val;
            if (sum == current && root.left == null && root.right == null){
                res.add(new ArrayList<>(tmp));
            }
            doPathSum(root.left,sum,tmp,current);
            doPathSum(root.right,sum,tmp,current);
            tmp.removeLast();
            current = current - root.val;
        }
    }
}
