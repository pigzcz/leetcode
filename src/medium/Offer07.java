package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * preorder = [3,9,8,5,4,10,20,15,7]
 * inorder = [4,5,8,10,9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Offer07 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }

        Map<Integer,Integer> inOrderIndex= new HashMap<>(inorder.length);
        for (int i=0;i<preorder.length;i++){

            inOrderIndex.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = findIndexInInOrder(inOrderIndex,preorder[0]);
        root.left = buildLeft(preorder,inorder,1,index,0,index-1,inOrderIndex);
        root.right = buildRight(preorder,inorder,index+1,inorder.length-1,index+1,inorder.length-1,inOrderIndex);
        return root;
    }
    public TreeNode buildLeft(int[] preorder,int[] inorder,int start, int end,int inStart,int inEnd,Map<Integer,Integer> inorderMap){
        if (start>end){
            return null;
        }
        int value = preorder[start];
        TreeNode treeNode = new TreeNode(value);
        int indexInInOrder = findIndexInInOrder(inorderMap, value);
        int leftCount = indexInInOrder-inStart;
        if (leftCount<=0){
            treeNode.left = null;
        } else {
            treeNode.left = buildLeft(preorder,inorder,start+1,start+leftCount,inStart,indexInInOrder-1,inorderMap);
        }

        treeNode.right = buildRight(preorder,inorder,start+leftCount+1,end,indexInInOrder+1,end,inorderMap);
        return treeNode;
    }
    public TreeNode buildRight(int[] preorder, int[] inorder, int start, int end,int inStart,int inEnd,Map<Integer,Integer> inorderMap){
        if (start>end){
            return null;
        }
        int value = preorder[start];
        TreeNode treeNode = new TreeNode(value);
        int indexInInOrder = findIndexInInOrder(inorderMap, value);
        int leftCount = indexInInOrder-inStart;
        if (leftCount<=0){
            treeNode.left = null;
        } else {
            treeNode.left = buildLeft(preorder,inorder,start+1,start+leftCount,inStart,indexInInOrder-1,inorderMap);
        }
        treeNode.right = buildRight(preorder,inorder,start+leftCount+1,end,indexInInOrder+1,end,inorderMap);
        return treeNode;
    }


    public int findIndexInInOrder(Map<Integer,Integer> inorder,int value){
        return inorder.getOrDefault(value,-1);
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        Offer07 offer07 = new Offer07();
        TreeNode treeNode = offer07.buildTree(pre, in);
        System.out.println(treeNode);
    }
}
