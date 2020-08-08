package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class Q99 {
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

    /**
     * 中序遍历二叉树，结果存入数组。
     * 将问题转化为递增数组交换了两个数找出
     * @param root
     */
    public void recoverTree2(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        zhongxu(root,treeNodeList);
        int[] index = new int[2];
        int k =0;
        for (int i =0;i<treeNodeList.size()-1;i++){
            if(k>1){
                break;
            }
            TreeNode treeNode = treeNodeList.get(i);
            TreeNode treeNode1 = treeNodeList.get(i + 1);
            if (treeNode.val>treeNode1.val){
                index[k] = i;
                k++;
            }
        }
        int i1 = index[0];
        int i2 = index[1];
        if (i2 == 0){
            TreeNode treeNode = treeNodeList.get(i1);
            TreeNode treeNode1 = treeNodeList.get(i1 + 1);
            int tmp = treeNode.val;
            treeNode.val = treeNode1.val;
            treeNode1.val = tmp;
        } else {
            TreeNode treeNode = treeNodeList.get(i1);
            TreeNode treeNode1 = treeNodeList.get(i2 + 1);
            int tmp = treeNode.val;
            treeNode.val = treeNode1.val;
            treeNode1.val = tmp;
        }

    }
    public void zhongxu(TreeNode root,List<TreeNode> treeNodes){
        if (root == null){
            return;
        }
        zhongxu(root.left,treeNodes);
        treeNodes.add(root);
        zhongxu(root.right,treeNodes);
    }

    /**
     *                                                                 5
     *                                                              /    \
     *                                                             3       8
     *                                                           /  \     /  \
     *                                                          2    4   7     12
     *                                                         /        /     /  \
     *                                                        1        6     10  14
     *
     *                                                                4
     *                                                              /    \
     *                                                             3       8
     *                                                           /  \     /  \
     *                                                          2    5   7     12
     *                                                         /        /     /  \
     *                                                        1        6     10    14
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }
        boolean b = rightMax(root, root.right);
        boolean b1 = leftMin(root, root.left);
        if (b&&b1){
            recoverTree(root.left);
            recoverTree(root.right);
        }  else if(!b && !b1) {
            findLeftMax(root.left);
            findRightMin(root.right);
            int tmp = max.val;
            max.val = min.val;
            min.val = tmp;
        }else if(!b){
            findRightMin(root.right);
            int tmp = min.val;
            min.val = root.val;
            root.val = tmp;
            return;
        } else if(!b1) {
            findLeftMax(root.left);
            int tmp = max.val;
            max.val = root.val;
            root.val = tmp;
            return;
        }
    }

    private TreeNode min;
    private TreeNode max;

    public boolean rightMax(TreeNode root, TreeNode right){
        if (null == right){
            return true;
        }
        if (root.val<right.val){
            return rightMax(root,right.right) && rightMax(root,right.left);
        } else {
            return false;
        }

    }
    public boolean leftMin(TreeNode root,TreeNode left){
        if (null == left){
            return true;
        }
        if (root.val>left.val){
            return leftMin(root,left.left) && leftMin(root,left.right);
        } else {
            return false;
        }
    }
    public void findRightMin(TreeNode right){
        if (null == right){
            return;
        }
        if (null == min){
            min = right;
        }
        if (right.val<min.val){
            min = right;
        }
        findRightMin(right.right);
        findRightMin(right.left);

    }
    public void findLeftMax(TreeNode left){
        if (null == left){
            return ;
        }
        if (null == max){
            max = left;
        }
        if (left.val>max.val){
            max = left;
        }
        findLeftMax(left.right);
        findLeftMax(left.left);
    }

    /**
     *       3
     *     1    4
     *         2
     *
     *
     *         2
     *       3    1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 =  new TreeNode(4);
        TreeNode r1l1 = new TreeNode(2);
        treeNode.left = l1;
        treeNode.right = r1;
        treeNode.right.left = r1l1;
        Q99 q99 = new Q99();
        q99.recoverTree(treeNode);
        System.out.println(true);
    }
}
