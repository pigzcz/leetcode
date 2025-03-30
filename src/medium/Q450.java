package medium;

import java.util.LinkedList;

public class Q450 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root.val == key) {
            if(root.left != null) {
                return addTreeNode(root.left, root.right);
            } else if (root.right != null){
                return addTreeNode(root.right, root.left);
            } else {
                return null;
            }
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    TreeNode addTreeNode(TreeNode root, TreeNode node) {
        if (node == null) {
            return root;
        }
        if(root == null) {
            return node;
        } else if(root.val > node.val) {
            root.left = addTreeNode(root.left, node);
        } else if(root.val < node.val) {
            root.right = addTreeNode(root.right, node);
        }
        return root;

    }

    public static void main(String[] args) {
        Q450 q450 = new Q450();
        TreeNode root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node3;
        root.right = node6;
        node6.right = node7;
        node3.left= node2;
        node3.right = node4;
        q450.deleteNode(root, 3);
    }

}
