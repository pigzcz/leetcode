package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:johnson.zhu
 * @Date: 2021/10/29 5:47 下午
 * @Description:
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 **/
public class Q230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> data = new ArrayList<>(10000);
        zhong(root,data);
        return data.get(k-1);
    }
    private void zhong(TreeNode root, List<Integer> data){
        if (root.left != null){
            zhong(root.left,data);
        }
        data.add(root.val);
        if (root.right != null){
            zhong(root.right,data);
        }
    }

}
