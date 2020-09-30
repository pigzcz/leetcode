package medium;

import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/8 17:40
 * @Description:
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Q236 {
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        parent(parentMap,root,null);
        Set<TreeNode> pp = new HashSet<>();
        pp.add(p);
        for(TreeNode parent = parentMap.get(p);null != parent;parent = parentMap.get(parent)){
            pp.add(parent);
        }
        if (pp.contains(q)){
            return q;
        }
        for (TreeNode parent = parentMap.get(q);null != parent; parent=parentMap.get(parent)){
            if (pp.contains(parent)){
                return parent;
            }
        }

        return null;
    }
    public void parent(Map<TreeNode,TreeNode> parentMap, TreeNode root,TreeNode parent){
        parentMap.put(root,parent);
        if (root.left != null){
            parent(parentMap,root.left,root);
        }
        if (root.right != null){
            parent(parentMap,root.right,root);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        root.left = l1;
        root.right = r1;
        TreeNode l1l1 = new TreeNode(6);
        TreeNode l1r1 = new TreeNode(2);
        l1.left=l1l1;
        l1.right = l1r1;
        TreeNode r1l1 = new TreeNode(0);
        TreeNode r1r1 = new TreeNode(8);
        r1.right = r1r1;
        r1.left = r1l1;
        TreeNode l1r1l1 = new TreeNode(7);
        TreeNode l1r1r1 = new TreeNode(4);
        l1r1.left = l1r1l1;
        l1r1.right = l1r1r1;
        Q236 q236 = new Q236();
        TreeNode treeNode = q236.lowestCommonAncestor(root, l1, l1r1r1);
        System.out.println(true);
    }
}
