/**
 * Created by admin on 2017/4/6.
 */
//  插入排序对链表进行排序
//  与数组相比，插入操作更简单，无需后移操作
//  差别：数组的插入排序  后移操作 遍历从尾部开始的
//    但是链表没有这个考虑
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
//        引入头结点 就不用对空串和第一个节点做特殊处理
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
