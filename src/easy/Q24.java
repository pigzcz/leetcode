package easy;

import java.util.List;

/**
 * LCR 024. 反转链表
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class Q24 {
    //迭代解法
    public ListNode reverseList(ListNode head) {
        if (head ==null) {
            return null;
        }
        ListNode pre = null;
        /**
         * 1 2 3 4 5
         * 5 4 3 2 1
         */
        while(head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }

    /**
     * 1 2 3 4 5 6
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
    public static class ListNode {
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Q24 q24 = new Q24();
        ListNode listNode = q24.reverseList2(listNode1);
        System.out.println(listNode);
    }
}
