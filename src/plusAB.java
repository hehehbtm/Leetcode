/**
 * Created by admin on 2017/4/6.
 */
// ��1�������������ʽ�洢�����мӷ�����
// ��2������Ӧ�õ������ļӷ�
// ��3���鲢�����е�merge �õ���ͬ�ķ���
// ��4���ϲ���������
public class plusAB {
    public ListNode plusAB(ListNode a, ListNode b) {
        int flag = 0;
        ListNode dummy = new ListNode(-1);
        ListNode index = dummy;
//        ��ֹ����  ��������ָ��β��
        while (a!=null||b!=null){
//            һ�������Ѿ���β������0����
            int one = a!=null?a.val:0;
            int two = b!=null?b.val:0;
            int cur = (one + two + flag)%10;
            flag = (one + two + flag)/10;
//            �ж�����
            if (a!=null) a = a.next;
            if (b!=null) b = b.next;
            index.next = new ListNode(cur);
            index = index.next;
        }
//        �����ڽ�λʱ������
        if (flag == 1)
            index.next = new ListNode(1);
        return dummy.next;
    }
}
