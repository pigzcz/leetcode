package easy;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 *
 * 输出：[3,2,1]
 *
 * 解释：
 *
 *
 *
 * 示例 2：
 *
 * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
 *
 * 输出：[4,6,7,5,2,9,8,3,1]
 *
 * 解释：
 *
 *
 *
 * 示例 3：
 *
 * 输入：root = []
 *
 * 输出：[]
 *
 * 示例 4：
 *
 * 输入：root = [1]
 *
 * 输出：[1]
 *
 *
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Q145 {

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        //上一个节点，比较巧妙，
        TreeNode prev = null;
        stack.add(node);
        while (!stack.isEmpty()) {
            while(node != null){
                stack.add(node);
                node = node.left;
            }
            stack.pop();
        }
        return res;
    }

    /**
     * 非递归算法1
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        //左孩子已经加入过栈的节点
        Set<TreeNode> left = new HashSet<>();
        //右孩子已经加入过栈的节点
        Set<TreeNode> right = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        stack.add(node);
        while (!stack.isEmpty()) {
            //没有孩子节点，就输出
            if(node.left == null && node.right == null) {
                res.add(node.val);
                //去掉当前节点
                stack.removeLast();
                //node设置栈的最后一个节点
                node = stack.peekLast();
                //左节点没有加入栈，就加进去
            } else if (node.left != null && !left.contains(node)) {
                stack.add(node.left);
                left.add(node);
                //最后的节点就是刚加进去的
                node = stack.getLast();
                //右节点没有加入进去，就加进去
            } else if(node.right != null && !right.contains(node)) {
                stack.add(node.right);
                right.add(node);
                node = stack.getLast();
                //其他情况输出
            } else {
                res.add(node.val);
                //去掉当前节点
                stack.removeLast();
                //node设置栈的最后一个节点
                node = stack.peekLast();
            }

        }
        return res;
    }
    public static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(18);
//        [18,9,27,6,15,24,30,3,null,12,null,21]

        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(27);
        root.left = l1;root.right = r1;
        TreeNode l1l = new TreeNode(6);
        TreeNode l1r = new TreeNode(15);
        l1.left = l1l;l1.right = l1r;
        TreeNode r1l = new TreeNode(24);
        TreeNode r1r = new TreeNode(30);
        r1.left = r1l;r1.right = r1r;
        TreeNode l1ll = new TreeNode(3);
        l1l.left = l1ll;
        TreeNode l1rl = new TreeNode(12);
        l1r.left = l1rl;
        TreeNode r1ll = new TreeNode(21);
        r1l.left = r1ll;
        Q145 q145 = new Q145();
        List<Integer> integers = q145.postorderTraversal(root);
        System.out.println(integers);
    }
}
