import java.util.LinkedList;

public class Q445 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        LinkedList<Integer> l11 = new LinkedList<>();
        LinkedList<Integer> l22 = new LinkedList<>();
        while (t1!=null || t2!=null){
            if (null != t1){
                l11.add(t1.val);
                t1 = t1.next;

            }
            if (null != t2){
                l22.add(t2.val);
                t2 = t2.next;

            }
        }


        boolean jinwei = false;
        ListNode last = null;
        ListNode now = null;

        while (l11.size()!=0 || l22.size()!=0){
            int i = 0;
            Integer i1 = l11.pollLast();
            if (null !=i1){
                i=i+i1;
            }
            Integer i2 = l22.pollLast();
            if (null != i2){
                i = i+i2;
            }
            if (jinwei){
                i=i+1;
            }
            if (i>=10){
                i = i-10;
                jinwei = true;
            } else {
                jinwei = false;
            }
            now = new ListNode(i);
            now.next = last;
            last = now;
        }
        if (jinwei){
            now = new ListNode(1);
            now.next = last;
        }
        return now;
    }
}
