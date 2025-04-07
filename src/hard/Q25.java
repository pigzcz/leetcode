package hard;

import medium.Q92;

import java.util.LinkedList;

/**
 * 25. K 个一组翻转链表
 * 困难
 * 相关标签
 * 相关企业
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<ListNode> stack = new LinkedList<>();
        //从堆栈取出的第一组数据，用来返回结果
        int i = 0;
        ListNode res = null;
        ListNode tmpLast = null;
        while (head != null) {
            stack.add(head);
            head = head.next;
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    ListNode tmp = stack.removeLast();
                    //第一次要建立头结点,用来返回结果
                    if (i == 0) {
                        res = tmp;
                        i ++ ;
                    }
                    //如果最后一个节点不是空，要指向当前节点
                    if (tmpLast != null) {
                        tmpLast.next = tmp;
                    }
                    //最后一个节点指向当前节点
                    tmpLast = tmp;
                }
            }
        }
        //最后如果不为空，说明堆栈里的元素不够k个
        while (!stack.isEmpty()) {
            ListNode tmp = stack.removeFirst();
            //说明之前处理过
            if (i == 0) {
                res = tmp;
                i ++ ;
            }
            if (tmpLast != null) {
                tmpLast.next = tmp;
            }
            tmpLast = tmp;
        }
        //去除循环数组可能性
        if (tmpLast != null) {
            tmpLast.next = null;
        }
        return res;
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
        Q25 q25 = new Q25();
        ListNode listNode = q25.reverseKGroup(listNode1, 2 );
        System.out.println(listNode);
    }
}
