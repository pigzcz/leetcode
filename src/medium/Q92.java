package medium;


import easy.Q24;

import java.util.List;

/**
 * 92. 反转链表 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class Q92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int length = 0;
        ListNode tmp = head;
        while (tmp.next != null) {
            length ++ ;
            tmp = tmp.next;
        }
        length = length +1;
        int i = 1;
        if (i == left) {
            return reverseBeforeN(head, right, length);
        }
        /**
         * 1 2 3 4 5
         * 1 4 3 2 5
         */
        ListNode res = head;
        ListNode tmpLast = null;
        ListNode tmpHead = null;
        ListNode pre = null;
        while(i <= right) {
            if (i < left) {
                tmpLast = head;
            }
            if (i == left) {
                tmpHead = head;
            }
            if (tmpHead != null) {
                ListNode tmptmp = head;
                head = head.next;
                tmptmp.next = pre;
                pre = tmptmp;
            } else {
                head = head.next;
            }
            i++;
        }
        tmpLast.next = pre;
        tmpHead.next = head;
        return res;
    }

    /**
     *  1 2 3 4 5
     *  4 3 2 1 5
     * @param head
     * @param right
     * @param length
     * @return
     */
    private ListNode reverseBeforeN(ListNode head, int right, int length) {
        int i = 1;
        if (i == right) {
            return head;
        }
        ListNode pre = null;
        ListNode tmpHead = head;
        while (i <= right) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = pre;
            pre = tmp;
            i ++ ;
        }
        tmpHead.next = head;
        return pre;
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
        Q92 q92 = new Q92();
        ListNode listNode = q92.reverseBetween(listNode1, 3 , 4);
        System.out.println(listNode);
    }
}
