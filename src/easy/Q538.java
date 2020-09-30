package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/21 10:28
 * @Description:
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class Q538 {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    /**
     *         2
     *      -3      3
     *   -4    -1
     *       -2
     *
     *
     *        2
     *      0   3
     *   -4   1
     *
     *   -4 0 1 2 3
     *
     *
     * @param root
     * @return
     */

    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> b = new ArrayList<>();
        bian(root,b);
        for (int i = b.size()-1;i>=0;i--){
            TreeNode tmp = b.get(i);
            int dex = i+1;
            if (dex<b.size()){
                TreeNode right = b.get(dex);
                tmp.val = right.val+tmp.val;
            }
        }
        return root;

    }

    public void bian(TreeNode root,List<TreeNode> list){
        if (null == root){
            return;
        }
        bian(root.left,list);
        list.add(root);
        bian(root.right,list);
    }
}
