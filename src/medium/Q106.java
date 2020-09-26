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
        Map<Integer,Integer> inmap = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            int value = inorder[i];
            inmap.put(value,i);
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

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
            node.right = buildChild(inoder,postorder,index-1,index-rightCount,instart,)
        }
    }
    public int findIndexInInOrder(Map<Integer,Integer> inorder,int value){
        return inorder.getOrDefault(value,-1);
    }

}
