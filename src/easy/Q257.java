package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/4 15:06
 * @Description:
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Q257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<Integer> tmp = new LinkedList<>();
        if (null == root){
            return res;
        }
        doBinaryTreePaths(root,tmp);
        return res;
    }
    private void doBinaryTreePaths(TreeNode root, LinkedList<Integer> tmp){
        tmp.add(root.val);
        if (root.left == null && root.right == null){
            res.add(toString(tmp));
            return;
        }
        if (root.left != null){
            doBinaryTreePaths(root.left,tmp);
            tmp.removeLast();
        }
        if (root.right != null){
            doBinaryTreePaths(root.right,tmp);
            tmp.removeLast();
        }
    }

    private String toString(LinkedList<Integer> tmp){
        StringBuilder builder = new StringBuilder();
        int i =0;
        for(Integer tt : tmp){
            if (i == tmp.size()-1){
                builder.append(tt);
            } else {
                builder.append(tt).append("->");
            }
            i++;
        }
        return builder.toString();
    }
}
