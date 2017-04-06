/**
 * Created by admin on 2017/4/6.
 */
// ��������й鲢����
//
public class SortList {
    public ListNode sortList(ListNode head) {
//        �ݹ����ֹ������  ����ֻ��һ��Ԫ�� ��������Ϊ��
        if (head == null||head.next ==null) return head;
        ListNode fast = head;
        ListNode slow = head;
//        �м�Ԫ�ص�ǰһ�� �ڵ�
        ListNode pre = null;
        while (fast!=null&&fast.next!=null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
//        �Ͽ�����
        pre.next = null;
//        �ֱ�����
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
//        �ϲ�
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
