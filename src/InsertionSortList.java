/**
 * Created by admin on 2017/4/6.
 */
//  ��������������������
//  ��������ȣ�����������򵥣�������Ʋ���
//  �������Ĳ�������  ���Ʋ��� ������β����ʼ��
//    ��������û���������
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
//        ����ͷ��� �Ͳ��öԿմ��͵�һ���ڵ������⴦��
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        ListNode current = head;
        while (current!=null){
            pre = res;
            while (pre.next!=null&&pre.next.val<current.val){
                pre = pre.next;
            }
            ListNode tmp = current.next;
            current.next = pre.next;
            pre.next = current;
            current = tmp;
        }
        return res.next;
    }
}
