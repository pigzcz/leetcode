package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/25 14:43
 * @Description:
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 通过次数61,274提交次数86,850
 */
public class Q106 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || postorder == null){
            return null;
        }
        if (inorder.length==0 || postorder.length==0){
            return null;
        }
        Map<Integer,Integer> inmap = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            int value = inorder[i];
            inmap.put(value,i);
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int indexInInOrder = findIndexInInOrder(inmap, postorder[postorder.length - 1]);
        int rightCount = indexInInOrder - postorder.length+1;
        root.right = buildChild(inorder,postorder,postorder.length-2,postorder.length-1+rightCount,postorder.length-1,inmap);
        root.left = buildChild(inorder,postorder,postorder.length-2+rightCount,0,indexInInOrder-1,inmap);
        return root;
    }

    public TreeNode buildChild(int[] inoder, int[] postorder,int index, int end,int instart, Map<Integer,Integer> inmap){
        if (index<end){
            return null;
        }
        int value = postorder[index];
        TreeNode node = new TreeNode(value);
        int indexInInOrder = findIndexInInOrder(inmap, value);
        int rightCount = indexInInOrder-instart;
        if (rightCount>=0){
            node.right=null;
        } else {
            node.right = buildChild(inoder,postorder,index-1,index+rightCount,instart,inmap);
        }
        node.left = buildChild(inoder,postorder,index+rightCount-1,end,indexInInOrder-1,inmap);
        return node;
    }
    public int findIndexInInOrder(Map<Integer,Integer> inorder,int value){
        return inorder.getOrDefault(value,-1);
    }

    public static void main(String[] args) {
        int[] ino = new int[]{9,3,15,20,7};
        int[] pr = new int[]{9,15,7,20,3};
        Q106 q106 = new Q106();
        TreeNode treeNode = q106.buildTree(ino, pr);
        System.out.println(treeNode);
    }

}
