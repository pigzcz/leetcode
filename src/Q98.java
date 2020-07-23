import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-05-05 09:56
 * @Description:
 */
public class Q98 {

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    private boolean res = true;
    public boolean isValidBST1(TreeNode root) {
          List<Integer> data = new ArrayList<>();
          zhongxu(root,data);
          return res;
    }

    public void zhongxu(TreeNode node, List<Integer> data){
          if (node == null){
              return;
          }
          zhongxu(node.left,data);
          if (data.size()!=0){
              Integer integer = data.get(data.size() - 1);
              if (node.val<=integer){
                  res = false;
                  return;
              }
          }

          data.add(node.val);
          zhongxu(node.right,data);
    }


    public boolean isValidBST(TreeNode root) {
        return doIsValidBst(root,new ArrayList<>(),new ArrayList<>());
    }
    public boolean doIsValidBst(TreeNode node, ArrayList<TreeNode> ll, ArrayList<TreeNode> rl){
        if(null == node){
            return true;
        }
        for (TreeNode tmp : ll){
            if (node.val>=tmp.val){
                return false;
            }
        }
        for (TreeNode tmp : rl){
            if (node.val<=tmp.val){
                return false;
            }
        }
        ArrayList clonel = (ArrayList)ll.clone();
        clonel.add(node);
        ArrayList cloner = (ArrayList)rl.clone();
        cloner.add(node);

        return doIsValidBst(node.left,clonel,rl)&&doIsValidBst(node.right,ll,cloner);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        root.left = left;
        Q98 q98 = new Q98();
        q98.isValidBST1(root);
    }
}
