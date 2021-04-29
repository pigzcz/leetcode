package easy;

/**
 * @author:johnson.zhu
 * @Date: 2021/4/29 4:56 下午
 * @Description:给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 **/
public class Q938 {
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
        Q938 q938 = new Q938();
        q938.rangeSumBST(root,18,24);
        System.out.println(q938.sum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (null != root){
            if (root.val >= low && root.val <= high){
                sum = sum + root.val;
                if (root.val != low){
                    findMin(root.left,low);
                }
                if (root.val != high){
                    findRight(root.right,high);
                }
            }
            if (root.val < low){
                rangeSumBST(root.right,low,high);
            }
            if (root.val > high){
                rangeSumBST(root.left,low,high);
            }
        }
        return sum;

    }
    public void findMin(TreeNode left,int low){
        if (null != left){
            if (left.val >= low){
                sum = sum + left.val;
                if (left.val != low){
                    findMin(left.left,low);
                }
                findMin(left.right,low);
            }
            if (left.val < low){
                findMin(left.right,low);
            }
        }
    }
    public void findRight(TreeNode right,int high){
        if (null != right){
            if (right.val <= high){
                sum = sum + right.val;
                findRight(right.left,high);
                if (right.val != high){
                    findRight(right.right,high);
                }
            }
            if (right.val > high){
                findRight(right.left,high);
            }
        }
    }
}
