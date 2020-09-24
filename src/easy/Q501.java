package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/24 10:16
 * @Description:
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 通过次数23,529提交次数49,343
 */
public class Q501 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    private Integer last;
    private int currentCount=0;
    private int maxCount=0;
    private List<Integer> res;
    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        doFind(root);
        if (currentCount>maxCount){
            res = new ArrayList<>();
            res.add(last);
            maxCount = currentCount;
            currentCount=1;
            last = root.val;
        } else if (currentCount == maxCount){
            currentCount=1;
            res.add(last);
            last = root.val;
        }
        int[] r = new int[res.size()];
        int j =0;
        for (Integer i : res){
            r[j]=i;
            j++;
        }
        return r;
    }

    public void doFind(TreeNode root){
        if (root == null){
            return;
        }
        doFind(root.left);
        if (last == null){
            currentCount=1;
            last = root.val;
        } else {
            if (last.equals(root.val)){
                currentCount++;
            } else {
                if (currentCount>maxCount){
                    res = new ArrayList<>();
                    res.add(last);
                    maxCount = currentCount;
                    currentCount=1;
                    last = root.val;
                } else if (currentCount == maxCount){
                    currentCount=1;
                    res.add(last);
                    last = root.val;
                } else {
                    currentCount=1;
                    last = root.val;
                }
            }
        }
        doFind(root.right);
    }
}
