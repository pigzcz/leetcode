package medium;

import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Q109 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


  public static class TreeNode {
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
    public TreeNode sortedListToBST(ListNode head) {

        return doSortedListToBST(head,null);
    }
    public TreeNode doSortedListToBST(ListNode head ,TreeNode treeNode){
        if (null == head){
            return treeNode;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode tmp = null;
        ListNode last = null;
        while (fast!= null && fast.next!=null){
            fast = fast.next.next;
            last = slow;
            slow = slow.next;
        }
        tmp = slow;
        ListNode right = tmp.next;
        if (last != null){
            last.next = null;
        } else {
            head = null;
        }

        if (treeNode == null){
            treeNode = new TreeNode(tmp.val);
        } else {
            addTree(treeNode,tmp.val);
        }
        doSortedListToBST(head,treeNode);
        doSortedListToBST(right,treeNode);
        return treeNode;


    }

    public TreeNode addTree(TreeNode treeNode,int val){
        if (null == treeNode){
            return new TreeNode(val);
        }
        if (val<treeNode.val){
            treeNode.left = addTree(treeNode.left,val);
        }
        if (val>treeNode.val){
            treeNode.right = addTree(treeNode.right,val);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        l1.next = l2;l2.next=l3;l3.next=l4;l4.next = l5;
        Q109 q109 = new Q109();
        TreeNode treeNode = q109.sortedListToBST(l1);
        System.out.println(true);
    }
}
