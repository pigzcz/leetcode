/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-26 09:23
 * @Description:
 */
public class Q23 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
          if (lists.length==1){
              return lists[0];
          }
        ListNode listNode = mergeKList(lists, 1, lists[0]);
          return listNode;

    }
    private ListNode mergeKList(ListNode[] lists, int index,ListNode current){
          if (index==lists.length){
              return current;
          }
        ListNode list = lists[index];
        ListNode re = null;
        ListNode f = null;
          while (list !=null || current!=null){
              if (list == null){
                  re = co(re,current);
                  if (f ==null){
                      f = re;
                  }
                  current = pollFirst(current);
                  continue;
              }
              if (current == null){
                  re = co(re,list);
                  if (f ==null){
                      f = re;
                  }
                  list = pollFirst(list);
                  continue;
              }
              if (list.val<current.val){
                  re = co(re,list);
                  if (f ==null){
                      f = re;
                  }
                  list = pollFirst(list);
              } else {
                  re =co(re,current);
                  if (f ==null){
                      f = re;
                  }
                  current = pollFirst(current);
              }
          }
          return mergeKList(lists,++index,f);
    }

    private ListNode co(ListNode re, ListNode val){
          if (re == null){
              re = val;
          } else {
              re.next = val;
              re = re.next;
          }
          return re;

    }

    private ListNode pollFirst(ListNode node){
          ListNode next = node.next;
          node.next = null;
          return next;
    }

    public static void main(String[] args) {
          Q23 q23 = new Q23();
        ListNode listNode = q23.new ListNode(1);
        ListNode l2 = q23.new ListNode(4);
        listNode.next = l2;
        ListNode l3 = q23. new ListNode(5);
        l2.next = l3;


        ListNode ll2 =q23. new ListNode(1);
        ListNode ll21 =q23. new ListNode(3);
        ll2.next = ll21;
        ListNode ll22 =q23. new ListNode(4);
        ll21.next= ll22;
        ListNode[] x = new ListNode[]{listNode,ll2};
        ListNode listNode1 = q23.mergeKLists(x);
        System.out.println(listNode1);


    }
}
