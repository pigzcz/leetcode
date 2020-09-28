package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/9/27 19:14
 * @Description:
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 */
public class QM0201 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> has = new HashSet<>();

        ListNode last = null;
        for (ListNode tmp = head;null != tmp;tmp = tmp.next){
            int value = tmp.val;
            if (has.contains(value)){
                last.next = tmp.next;
            } else {
                has.add(tmp.val);
                last = tmp;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;
        QM0201 qm0201 = new QM0201();
        ListNode listNode = qm0201.removeDuplicateNodes(l1);
        System.out.println(l1);
    }
}
