package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 285. 二叉搜索树中的顺序后继
 * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 *
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3], p = 1
 * 输出: 2
 * 解析: 这里 1 的顺序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2:
 *
 *
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * 输出: null
 * 解析: 因为给出的结点没有顺序后继，所以答案就返回 null 了。
 */
public class Q285 {
    private boolean find = false;
    private TreeNode result = null;
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null){
            return null;
        }
        List<TreeNode> list = new LinkedList<>();
        bianli(root,list);
        boolean find = false;
        for (TreeNode tmp : list){
            if (find){
                return tmp;
            }
            if (tmp.val == p.val){
                find = true;
            }
        }
        return null;
    }
    public void bianli(TreeNode root,List<TreeNode> list){
        if(null == root){
            return;
        }
        bianli(root.left,list);
        list.add(root);
        bianli(root.right,list);
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (p == null){
            return null;
        }

        bianli(root,p);
        return result;
    }
    public void bianli(TreeNode root,TreeNode p){

        if (null == root){
            return;
        }


        bianli(root.left,p);
        if (p.val < root.val && result == null){
            result = root;
            return;
        }
        bianli(root.right,p);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Q285 q285 = new Q285();
        TreeNode treeNode = q285.inorderSuccessor2(root, left);
        System.out.println(true);
    }
}
