/**
 * Created by admin on 2017/4/7.
 */
class Elem{
    int value;
    int min;
    Elem next;
    public Elem(int value, int min) {
        this.value = value;
        this.min = min;
    }
}
//  最小栈   返回最小元素的时间复杂度是O（1）
//  方法  （1）用链表实现栈  ，在链表节点中保存最小值
//  方法 （2）用双栈实现  压栈时，如果保存最小值的元素比栈顶元素小，元素压栈
//      （3） 弹出时，等于栈顶元素 元素出栈
public class MinStack {
    Elem top;

    public MinStack() {
    }
//    插入
    public void push(int value){
        if (top == null)
            top = new Elem(value,value);
        else{
            Elem elem = new Elem(value,Math.min(value,top.min));
            elem.next = top;
            top = elem;
        }
    }
//    删除
    public void pop(){
        if (top == null)
            return;
        top = top.next;
    }
//    peek
    public int top(){
        return top.value;
    }
//    min
    public int getMin(){
        return top.min;
    }
}
