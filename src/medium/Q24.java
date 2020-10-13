package medium;

public class Q24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode res = null;
        if (head == null){
            return res;
        }
        if (head.next == null){
            return head;
        }
        res = head.next;
        ListNode listNode = swapTwo(null, head);
        for (ListNode f = listNode;f.next != null;){
            f = swapTwo(f,f.next);
        }
        return res;
    }
    public ListNode swapTwo(ListNode last,ListNode node){
        ListNode next = node.next;
        if (next == null){
            return node;
        }
        ListNode nn = next.next;
        if (null != last){
            last.next = next;
        }
        next.next = node;
        node.next = nn;
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;l2.next=l3;l3.next=l4;l4.next=l5;
        Q24 q24 = new Q24();
        ListNode listNode = q24.swapPairs(l1);
        System.out.println(listNode);


    }
}
