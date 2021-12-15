package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:johnson.zhu
 * @Date: 2021/12/15 10:10 下午
 * @Description:
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 分析树的前序遍历为根节点左子树右子树
 * 中序遍历为左子树根节点右子树
 * 所以前序遍历的第一个一定是根节点，这时候去中序的数组定位他的index左边的数据就是左子树，右边的数据就是右子树
 * 递归操作
 **/
public class Q105 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }

        /**
         * 构建谦虚遍历在中序的位置
         */
        Map<Integer, Integer> zhongIndexMap = new HashMap<>();
        for (int i=0;i < inorder.length;i++){
            zhongIndexMap.put(inorder[i],i);
        }
        return buildChild(0,0,inorder.length-1,preorder,inorder,zhongIndexMap);
    }

    /**
     *
     * @param preStart 指在前序遍历数组的开始下标，这个下标就是此次构建的根节点
     * @param inStart 指在中序遍历数组的开始下标，
     * @param inEnd 指在中序遍历数组截止下标 这两个下标共同构建出了当前子数的数据范围
     * @param preorder
     * @param inorder
     * @param innerMap
     * @return
     */
    private TreeNode buildChild(int preStart,int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer,Integer> innerMap){
        if (inStart>inEnd){
            return null;
        }
        int value = preorder[preStart];
        TreeNode root = new TreeNode(value);
        /**
         * 找到根节点在中序遍历的index
         * 左子树的preStart永远是根数的preStart+1,
         * 右子树的preStart则根据index来判定，x=index-instart表示左子树总共有多少的数据，右子树的preStart需要跳过这些数，右子树的preStart=prestart+x+1
         */
        Integer index = innerMap.get(value);
        root.left = buildChild(preStart+1,inStart,index-1,preorder,inorder,innerMap);
        root.right = buildChild(preStart+index-inStart+1,index+1,inEnd,preorder,inorder,innerMap);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        Q105 q105 = new Q105();
        TreeNode treeNode = q105.buildTree(pre, in);
        System.out.println(treeNode);;
    }
}
