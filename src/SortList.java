/**
 * Created by admin on 2017/4/6.
 */
// 对链表进行归并排序
//
public class SortList {
    public ListNode sortList(ListNode head) {
//        递归的终止条件是  链表只有一个元素 或者链表为空
        if (head == null||head.next ==null) return head;
        ListNode fast = head;
        ListNode slow = head;
//        中间元素的前一个 节点
        ListNode pre = null;
        while (fast!=null&&fast.next!=null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
//        断开链表
        pre.next = null;
//        分别排序
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
//        合并
        return merge(first,second);
    }
    public ListNode merge(ListNode pre,ListNode next){
        ListNode dummy = new ListNode(-1);
        ListNode index = dummy;
        while (pre!=null&&next!=null){
            if (pre.val<next.val){
                index.next = pre;
                pre = pre.next;
            }else {
                index.next = next;
                next = next.next;
            }
            index = index.next;
        }
        if (pre!=null)
            index.next = pre;
        if (next!=null)
            index.next = next;
        return dummy.next;
    }
}
