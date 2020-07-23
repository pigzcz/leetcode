import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-22 09:49
 * @Description:
 */
public class Q199 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()){

            TreeNode treeNode = null;
            int size = queue.size();
            LinkedList<TreeNode> next = new LinkedList<>();
            while ((treeNode = queue.pollFirst())!=null){
                if (queue.size()==size-1){
                    res.add(treeNode.val);
                }
                if (null != treeNode.right){
                    next.add(treeNode.right);
                }
                if (null != treeNode.left){
                    next.add(treeNode.left);
                }
            }
            queue=next;

        }
        return res;
    }
}
