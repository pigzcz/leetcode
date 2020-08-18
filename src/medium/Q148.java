package medium;

import java.util.List;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/17 21:31
 * @Description:
 */
public class Q148 {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode sortList(ListNode head) {
          if(null == head || head.next == null ){
              return head;
          }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode tmp = null;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null){
                tmp = slow.next;
                slow.next =null;
                break;
            }
        }
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode res = null;
        while (left != null || right != null){
            if (left == null){
                ListNode het = right;
                right = right.next;
                enq(res,het);
                continue;
            }
            if (right == null){
                ListNode het = left;
                left = left.next;
                enq(res,het);
                continue;
            }
            if (left != null && right != null){
                if (left.val<=right.val){
                    ListNode het = left;
                    left = left.next;
                    enq(res,het);
                } else {
                    ListNode het = right;
                    right = right.next;
                    enq(res,het);
                }
                continue;
            }
        }
        return res;
    }

    ListNode enq(ListNode res,ListNode cu){
          if (res == null){
              res = cu;
          } else {
              res.next = cu;
          }
          cu.next = null;
          return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Q148 q148 = new Q148();
        ListNode listNode = q148.sortList(l1);
        System.out.println(l1);
    }
}
