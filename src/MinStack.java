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
//  ��Сջ   ������СԪ�ص�ʱ�临�Ӷ���O��1��
//  ����  ��1��������ʵ��ջ  ��������ڵ��б�����Сֵ
//  ���� ��2����˫ջʵ��  ѹջʱ�����������Сֵ��Ԫ�ر�ջ��Ԫ��С��Ԫ��ѹջ
//      ��3�� ����ʱ������ջ��Ԫ�� Ԫ�س�ջ
public class MinStack {
    Elem top;

    public MinStack() {
    }
//    ����
    public void push(int value){
        if (top == null)
            top = new Elem(value,value);
        else{
            Elem elem = new Elem(value,Math.min(value,top.min));
            elem.next = top;
            top = elem;
        }
    }
//    ɾ��
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
