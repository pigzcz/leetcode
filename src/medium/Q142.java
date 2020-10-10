package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/10/10 14:03
 * @Description:
 */
public class Q142 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while (tmp!=null){
            if (set.contains(tmp)){
                return tmp;
            } else {
                set.add(tmp);
            }
            tmp = tmp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;l2.next = l3;l3.next = l4;l4.next=l2;
        Q142 q142 = new Q142();
        ListNode listNode = q142.detectCycle(l1);
        System.out.println(listNode);
    }
}
