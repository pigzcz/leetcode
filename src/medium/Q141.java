package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/10/10 14:50
 * @Description:
 */
public class Q141 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while (tmp!=null){
            if (set.contains(tmp)){
                return true;
            } else {
                set.add(tmp);
            }
            tmp = tmp.next;
        }
        return false;
    }
}
