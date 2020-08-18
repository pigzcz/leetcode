package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/17 20:13
 * @Description:
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result = null;
      ListNode realR = null;
      int jinwei = 0;
      while (l1!=null || l2!= null || jinwei !=0){
          int res = jinwei;
          if (null != l1){
              res = res + l1.val;
          }
          if (null != l2){
              res = res + l2.val;
          }
          if (res>=10){
              jinwei = 1;
              res = res-10;
          } else {
              jinwei = 0;
          }
          if (null == result){
              result = new ListNode(res);
              realR = result;
          } else {
              ListNode next = new ListNode(res);
              result.next = next;
              result = result.next;

          }
          if (null != l1){
              l1 = l1.next;
          }
          if (null != l2){
              l2 = l2.next;
          }
      }
      return realR;
    }


}
