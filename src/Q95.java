import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q95 {
    public class TreeNode {
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

    public static void main(String[] args) {
//        double pow = Math.pow(2, 8);
//
        Q95 q95 = new Q95();
//        List<int[]> lists = q95.getLists(8);
//        System.out.println(lists);

        int[] ss = new int[5];
        ss[1]=5;
        String s = q95.arrayToString(ss);
        List<TreeNode> treeNodes = q95.generateTrees(8);

        System.out.println(s);
    }

    /**
     * solution1
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        int size = (int)Math.pow(2,n)-1;
        if (n == 0){
            return result;
        }
        TreeNode treeNode = new TreeNode(1);
        if (n==1){
            result.add(treeNode);
            return result;
        }
        List<int[]> lists = getLists(n);
        Set<String> index = new HashSet<>();

        for (int[] tmp : lists){
            TreeNode start = new TreeNode(tmp[0]);
            int[] list = new int[size];
            list[0] = tmp[0];
            for (int i=1;i<tmp.length;i++){
                addChild(start,tmp[i],list,0);
            }
            String s = arrayToString(list);
            if (!index.contains(s)){
                result.add(start);
                index.add(s);
            }


        }

        return result;
    }

    private List<int[]> getLists(int n){
        if (n==0){
            return null;
        }
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{1});
        if (n==1){
            return result;
        }
        for (int i=2;i<=n;i++){
            List<int[]> tmpList = new ArrayList<>();
            for (int[] tmp : result){
                List<int[]> add = add(i, tmp);
                tmpList.addAll(add);
            }
            result = tmpList;
        }
        return result;
    }

    private List<int[]> add(int n,int[] tmp){
        List<int[]> result = new ArrayList<>();
        for (int count = 0;count<n;count++){
            int[] tt = new int[tmp.length+1];
            int k =0;
            for (int i=0;i<n;i++){
                if (i==count){
                    tt[i]=n;
                } else {
                    tt[i]=tmp[k];
                    k++;
                }
            }
            result.add(tt);


        }
        return result;
    }


    String arrayToString(int[] list){
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<list.length;i++){
            sb.append(list[i]);
        }
        return sb.toString();
    }
    public void addChild(TreeNode t, int value,int[] list,int index){
        if (value >t.val){
            if (t.right == null){
                t.right = new TreeNode(value);
                list[(index+1)*2] = value;
            } else {
                addChild(t.right,value,list,(index+1)*2);
            }
        }
        if (value < t.val){
            if (t.left == null){
                t.left = new TreeNode(value);
                list[(index+1)*2-1] = value;
            } else {
                addChild(t.left,value,list,(index+1)*2-1);
            }
        }
    }


    /**
     * solution 2
     */

    public List<TreeNode> generateTrees2(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        return generateTree(1,n);
    }
    public List<TreeNode> generateTree(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start>end){
            result.add(null);
            return result;
        }

        for (int i =start;i<=end;i++){


            List<TreeNode> lefts = generateTree(start, i - 1);
            List<TreeNode> rights = generateTree(i + 1, end);
            for (TreeNode left : lefts){
                for (TreeNode right : rights){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}
