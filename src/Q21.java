/**
 * @Auther: johnson.zhu
 * @Date: 2020-05-01 07:01
 * @Description:
 */

public class Q21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode rerl = null;
        while(l1 != null || l2 != null){
            ListNode tmp = null;
            if(l1 == null){
                tmp = l2;
                l2 = l2.next;
            } else if(l2 == null){
                tmp = l1;
                l1 = l1.next;

            } else if(l1.val<l2.val){
                tmp = l1;
                l1 = l1.next;

            } else{
                tmp = l2;
                l2=l2.next;
            }
            if(res == null){
                res = tmp;
                rerl = res;
            } else{
                res.next = tmp;
                res = res.next;
            }

        }
        return rerl;
    }

    public static void main(String[] args) {
        Q21 q21 = new Q21();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        ListNode listNode2 = q21.mergeTwoLists(listNode, listNode1);

    }
}
