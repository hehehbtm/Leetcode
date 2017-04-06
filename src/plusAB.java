/**
 * Created by admin on 2017/4/6.
 */
// （1）数以链表的形式存储，进行加法运算
// （2）可以应用到大数的加法
// （3）归并排序中的merge 用到相同的方法
// （4）合并有序链表
public class plusAB {
    public ListNode plusAB(ListNode a, ListNode b) {
        int flag = 0;
        ListNode dummy = new ListNode(-1);
        ListNode index = dummy;
//        终止条件  两个链表都指向尾部
        while (a!=null||b!=null){
//            一个链表已经到尾部，用0补齐
            int one = a!=null?a.val:0;
            int two = b!=null?b.val:0;
            int cur = (one + two + flag)%10;
            flag = (one + two + flag)/10;
//            判断条件
            if (a!=null) a = a.next;
            if (b!=null) b = b.next;
            index.next = new ListNode(cur);
            index = index.next;
        }
//        最后存在进位时，处理
        if (flag == 1)
            index.next = new ListNode(1);
        return dummy.next;
    }
}
