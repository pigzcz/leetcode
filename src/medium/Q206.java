package medium;

import java.util.LinkedList;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/8 17:05
 * @Description:
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Q206 {
      public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next ==null){
            return head;
        }

        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (head.next!=null){
            listNodes.addLast(head);
            head=head.next;
        }
        listNodes.addLast(head);
        head = listNodes.pollLast();
        ListNode realHead = head;

        while (listNodes.size()!=0){
            ListNode next = listNodes.pollLast();
            head.next = next;
            head = next;
        }
        if (listNodes.size() == 0){
            head.next = null;
        }
        return realHead;
    }

}
